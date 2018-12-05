requires('/static/js/component/component.js', '/static/js/component/basic.js').imports();

function Table(id, editable) {
    Component.call(this, id, "table");

    this.thead = document.createElement("thead");
    this.tbody = document.createElement("tbody");
    this.editors = [];
    this.defaultEditor = null;
    this.selectedRow = null;
    if (editable !== undefined) {
        this.editable = editable;
        this.data = editable;
    } else {
        this.editable = true;
        this.data = true;
    }
    let that = this;
    this.actionBar = null;

    this.pageable = false;
    this.pagingBar = null;

    this.selectable = false;

    this.component.appendChild(this.thead);
    this.component.appendChild(this.tbody);

    this.setColumns = function (columns) {
        if (this.editable) {
            for (let i = 0; i < columns.length; i++) {
                if (columns[i]["editor"] !== undefined && columns[i]["editor"] !== null) {
                    this.editors.push(columns[i]["editor"]);
                } else {
                    this.editors.push(this.createDefaultEditor());
                }
            }
            this.thead.appendChild(this.createActionBar().getComponent());
        }
        if (this.pageable) {
            if (this.pagingBar === null) {
                this.component.appendChild(this.createPagingBar(columns.length).getComponent());
            } else {
                let td = this.pagingBar.getComponent().getElementsByTagName("td");
                if (td !== undefined && td.length > 0) {
                    td[0].setAttribute("colspan", columns.length);
                }
            }
        }
        this.thead.appendChild(this.createCols(columns));
    };

    this.createPagingBar = function (colCount) {
        this.pagingBar = new PagingBar("pagingBar", colCount);
        this.pagingBar.setTable(this);
        this.pagingBar.setLoadAction(that.load);
        return this.pagingBar;
    };

    this.getPagingBar = function () {
        return this.pagingBar;
    };

    this.setPageData = function (pageData) {
        that.pagingBar.setPage(pageData);
        that.setData(pageData.data);
    };

    this.createActionBar = function () {
        if (that.actionBar === null) {
            that.actionBar = new ActionBar("actionBar",
                new Action("新增", function () {
                    that.addRow(null, null);
                    var evt = document.createEvent('Event');
                    evt.initEvent('resize', true, true);
                    that.getComponent().dispatchEvent(evt);
                }),
                new Action("删除", function () {
                    if (that.selectedRow !== null) {
                        that.delRow(that.selectedRow);
                        that.selectedRow = null;
                        var evt = document.createEvent('Event');
                        evt.initEvent('resize', true, true);
                        that.getComponent().dispatchEvent(evt);
                    }
                }));
        }
        that.actionBar.getComponent().style.width = this.getComponent().style.width;
        return that.actionBar;
    };

    this.getActionBar = function () {
        return this.actionBar;
    };

    this.setActions = function () {
        let args = [];
        for (let act of arguments) {
            args.push(act);
        }
        if (this.actionBar !== null) {
            this.actionBar.setActions(args);
        }
    };

    this.createCols = function (coldata) {
        let row = document.createElement("tr");
        let i = 0;
        let len = coldata.length;
        if (this.selectable) {// 显示复选框列
            let emptyCol = this.createCell("th", "", i, 0, false);
            emptyCol.style.width = "20px";
            row.appendChild(emptyCol);
            i = 1;
            len += 1;
        }
        for (; i < len; i++) {
            let cell = null;
            if (coldata[i] instanceof TableColumn) {
                cell = this.createCell("th", coldata[i].name, i, 0, false);
                cell.setAttribute("field-code", coldata[i].code);
                cell.style.width = coldata[i].width;
            } else {
                cell = this.createCell("th", coldata[i], i, 0, false);
            }
            row.appendChild(cell);
        }
        return row;
    };

    this.createRow = function (tag, rowdata, rowIndex, editable) {
        let row = document.createElement("tr");
        let table = that;
        if (rowIndex === undefined || rowIndex === null) {
            rowIndex = this.component.rows.length;
        }

        row.onclick = function () {
            row.style.background = "#F5F5F5";
            row.setAttribute("selected", "true");
            if (table.selectedRow === undefined || table.selectedRow === null) {
                table.selectedRow = row.rowIndex;
            } else {
                table.getComponent().rows[table.selectedRow].style.background = "";
                table.getComponent().rows[table.selectedRow].setAttribute("selected", null);
                table.selectedRow = null;
            }
        };

        let ths = this.thead.getElementsByTagName("th");
        let colLen = ths.length;
        let i = 0;
        if (this.selectable) {
            // TODO
            let td = document.createElement("td");
            let check = new CheckboxButton("table-checker", "");
            //.table-check
            check.setStyle("position", "relative");
            check.setStyle("width", "12px");
            check.setStyle("height", "12px");
            check.setStyle("margin", "0px auto");
            check.setStyle("opacity", "1");
            check.setStyle("top", "0px");
            td.appendChild(check.getComponent());
            row.appendChild(td);
            i = 1;
        }
        for (; i < colLen; i++) {
            let data = null;
            if (rowdata !== null && rowdata[i] !== undefined) {
                data = rowdata[i];
            } else if (rowdata !== null) {
                let fieldCode = ths[i].getAttribute("field-code");
                if (rowdata[fieldCode] !== undefined) {
                    data = rowdata[fieldCode];
                }
            }
            row.appendChild(this.createCell(tag, data, i, rowIndex, editable));
        }
        return row;
    };

    this.createCell = function (tag, cellData, colIndx, rowIndx, editable) {
        let td = document.createElement(tag);
        td.setAttribute("row", rowIndx);
        td.setAttribute("column", colIndx);
        let label = document.createElement("span");
        let value = document.createElement("span");
        let valueId = this.cellValueId(colIndx, rowIndx);
        let labelId = this.cellLabelId(colIndx, rowIndx);

        value.setAttribute("id", valueId);
        label.setAttribute("id", labelId);

        if (cellData !== undefined) {
            label.innerText = cellData;
            value.innerText = cellData;
        }

        value.style.setProperty("display", "none");
        label.style.setProperty("word-wrap", "break-word");

        td.appendChild(label);
        td.appendChild(value);

        if (editable) {
            let editors = this.editors;
            let defaultEditor = this.createDefaultEditor();
            td.ondblclick = function (e) {
                let cell = e.currentTarget;
                let colIndx = cell.getAttribute("column");
                //let rowIndx = cell.getAttribute("row");
                let editor = null;//getEditor(colIndx, rowIndx);
                if (editors[colIndx] !== undefined) {
                    editor = editors[colIndx];
                } else {
                    editor = defaultEditor;
                }
                if (editor.isPacked !== undefined && editor.isPacked()) {
                    editor = editor.getComponent();
                }
                editor.className = "table-editor";
                editor.value = cell.innerText;

                editor.onblur = function () {
                    if (editor.tagName.toLowerCase() === 'select') {
                        let option = editor.options[editor.selectedIndex];
                        if (option !== undefined) {
                            cell.children[0].innerText = option.text;
                            cell.children[1].innerText = option.value;
                        }
                    } else {
                        cell.children[0].innerText = editor.value;
                        cell.children[1].innerText = editor.value;
                    }
                    cell.children[0].style.display = "";
                    cell.removeChild(editor);
                };
                cell.children[0].style.display = "none";
                cell.appendChild(editor);
                editor.focus();
            }
        }
        return td;
    };

    this.cellValueId = function (colIndx, rowIndx) {
        return "c" + colIndx + "r" + rowIndx + "_value";
    };

    this.cellLabelId = function (colIndx, rowIndx) {
        return "c" + colIndx + "r" + rowIndx + "_label";
    };

    this.setEditor = function (col, editor) {
        this.editors[col] = editor;
    };

    this.setData = function (data) {
        this.clear();
        for (let i = 0; i < data.length; i++) {
            let rowdata = data[i];
            let row = this.createRow("td", rowdata, i, this.editable);
            this.tbody.appendChild(row);
        }
    };

    this.clear = function () {
        this.tbody.innerText = "";
    };

    this.addRow = function (rowdata, rowIndex) {
        this.tbody.appendChild(this.createRow("td", rowdata, rowIndex, this.editable));
    };

    this.delRow = function (index) {
        this.getComponent().deleteRow(index);
    };

    this.addCol = function () {

    };

    this.setSelectable = function (selectable) {
        this.selectable = selectable;
        if (selectable) {
            let headRows = this.thead.childNodes;
            if (headRows === null || headRows.length === 0) {
                return;
            }
            let headRow = headRows[0];
            let childNodes = headRow.childNodes;
            let cell = this.createCell("th", "", 0, 0, false);
            cell.style.width = "14px";
            if (childNodes !== null && childNodes.length > 0) {
                headRow.insertBefore(cell, childNodes[0]);
                if (this.tbody.rows !== null && this.tbody.rows.length > 0) {
                    for (let i = 0;i < this.tbody.rows.length;i++) {
                        let td = document.createElement("td");
                        let check = new Checkbox("table-checker", "", i);
                        td.appendChild(check.getComponent());
                        this.tbody.childNodes[i].insertBefore(td, this.tbody.childNodes[i][0]);
                    }
                }
            } else {
                headRow.appendChild(cell);
            }
        }
    };

    this.delCol = function (index) {
        let count = this.getComponent().rows.length;
        for (let i = 0;i < count;i++) {
            this.getComponent().rows[i].deleteCell(index);
        }
    };

    this.createDefaultEditor = function () {
        if (this.defaultEditor === null) {
            let id = this.component.getAttribute("id");
            let editor = new TextField(id);
            this.defaultEditor = editor.getComponent();
        }
        return this.defaultEditor;
    };

    this.collectData = function () {
        let rows = this.component.rows;
        let cols = rows[0].cells;
        let data = [];
        for (let i = 1; i < rows.length; i++) {
            let dataRow = {};
            let cells = rows[i].cells;
            for (let j = this.selectable ? 1 : 0; j < cells.length; j++) {
                let fieldcode = cols[j].getAttribute("field-code");
                if (fieldcode !== undefined) {
                    dataRow[fieldcode] = cells[j].children[1].innerText;
                }
            }
            data.push(dataRow);
        }
        return data;
    };

    this.setEditable = function (editable) {
        if (editable) {
            if (this.actionBar === null) {
                this.createActionBar();
            }
            this.actionBar.getComponent().style.display = "";
            let ths = this.thead.getElementsByTagName("th");
            let lastTh = ths[ths.length - 1];
            lastTh.style.display = "";
        } else {
            this.actionBar.getComponent().style.display = "none";
            let ths = this.thead.getElementsByTagName("th");
            let lastTh = ths[ths.length - 1];
            lastTh.style.display = "none";
        }
    };

    this.setPageable = function (pageable) {
        this.pageable = pageable;
        if (pageable) {
            if (this.pagingBar === null) {
                let ths = this.thead.getElementsByTagName("th");
                this.component.appendChild(this.createPagingBar(ths.length).getComponent());
            }
            this.pagingBar.getComponent().style.display = "";
        } else {
            if (this.pagingBar !== null) {
                this.pagingBar.getComponent().style.display = "none";
            }
        }
    };

    this.setPageNum = function (pageNum) {
        let page = this.pagingBar.getPage();
        page.pageNum = pageNum;
        this.pagingBar.setPage(page);
    };

    this.setOperations = function (operations) {

    };

    this.load = function (load) {
        load(this);
        this.pagingBar.setLoadAction(load);
    };

    this.setPageLoadAction = function (func) {
        this.pagingBar.setLoadAction(func);
    };

    this.refresh = function (func) {
        if (func !== undefined && func !== null) {
            func();
        }
    };

}

function TableColumn(name, code, editor, width) {
    this.name = name;
    this.code = code;
    this.editor = editor;
    this.width = width;
}

function PagingBar(id, colCount, page, table) {
    Component.call(this, id, "tFoot");
    this.table = table;
    let row = document.createElement("tr");
    let col = document.createElement("td");
    col.setAttribute("colspan", colCount);
    col.style.border = "none";
    row.appendChild(col);

    let pageBtns = document.createElement("ul");
    pageBtns.style.float = "center";

    let that = this;

    this.setTable = function (table) {
        this.table = table;
    };

    this.getComponent().appendChild(row);
    this.pageAction = function (e) {
        let button = e.currentTarget;
        let pageNum = button.getAttribute("pagenum");
        that.page.pageNum = parseInt(pageNum);
        //that.setPage(that.page);
        that.loadAction(that.table);
    };

    let pa = this.pageAction;
    this.setPage = function (page) {
        that.page = page;
        if (col.hasChildNodes()) {
            col.removeChild(pageBtns);
            pageBtns = document.createElement("ul");
        }
        //pageBtns.style.display = "inline-block";// display: inline-block;横向排布
        let prePageNum = page.pageNum - 1 > 0 ? page.pageNum - 1 : 1;
        let nextPageNum = page.pageNum + 1 < page.totalPage ? page.pageNum + 1 : page.totalPage;
        let prePage = pageButton("pre", "<<", page.pageNum === 1, pa, prePageNum);
        let nextPage = pageButton("next", ">>", page.pageNum === page.totalPage, pa, nextPageNum);
        let firstPage = pageButton("first", "首页", page.pageNum === 1, pa, 1);
        let lastPage = pageButton("last", "尾页", page.pageNum === page.totalPage, pa, page.totalPage);
        pageBtns.appendChild(firstPage);
        pageBtns.appendChild(prePage);

        if (page !== undefined) {
            if (page.pageNum > 5 && page.pageNum <= page.totalPage - 5) {
                let page1 = pageButton("page1", 1, false, pa, 1);
                let page2 = pageButton("page2", 2, false, pa, 2);

                pageBtns.appendChild(page1);
                pageBtns.appendChild(page2);
                pageBtns.appendChild(omitText());

                let endPage = (page.pageNum + 3) > page.totalPage ? page.totalPage : page.pageNum + 3;

                for (let i = page.pageNum - 2; i < endPage; i++) {
                    pageBtns.appendChild(pageButton("page" + i, i, page.pageNum === i, pa, i));
                }
                pageBtns.appendChild(omitText());
            } else if (page.pageNum <= 5) {
                let len = page.pageNum + 2 < 6 ? 6 : page.pageNum + 2;
                len = len > page.totalPage ? page.totalPage : len;
                for (let i = 1; i <= len; i++) {
                    pageBtns.appendChild(pageButton("page" + i, i, page.pageNum === i, pa, i));
                }
                if (page.totalPage > 6) {
                    pageBtns.appendChild(omitText());
                }
            } else {
                pageBtns.appendChild(omitText());
                let start = page.pageNum > page.totalPage - 5 ? page.totalPage - 5 : page.totalPage - 6;
                for (let i = start; i <= page.totalPage; i++) {
                    pageBtns.appendChild(pageButton("page" + i, i, page.pageNum === i, pa, i));
                }
            }
        }

        pageBtns.appendChild(nextPage);
        pageBtns.appendChild(lastPage);
        col.appendChild(pageBtns);
    };

    this.getPage = function () {
        return this.page;
    };

    this.setLoadAction = function (func) {
        this.loadAction = func;
    };

    if (page !== undefined) {
        this.setPage(page);
    }

}

function pageButton(id, text, isCurrent, jump, page) {
    let button = new Button(id, text);
    let pageButton = document.createElement("li");
    pageButton.style.display = "inline-block"; // style="display: inline-block;"
    if (isCurrent !== undefined && isCurrent) {
        button.getComponent().disabled = true;
        button.getComponent().style.color = "#4a4a4a"
        button.getComponent().style.background = "#FFFFFF";
    }
    button.getComponent().setAttribute("pagenum", page);
    button.setOnclick(jump);
    pageButton.appendChild(button.getComponent());
    return pageButton;
}

function omitText() {
    let omitText = document.createElement("li");
    omitText.style.display = "inline-block";// style="display: inline-block;"
    omitText.innerText = "…";
    return omitText;
}

function Page(pageNum, pageSize, totalPage, totalCount, data) {
    this.pageNum = pageNum;
    this.pageSize = pageSize;
    this.totalPage = totalPage;
    this.totalCount = totalCount;
    this.data = data;
}

function Action(name, func) {
    this.name = name;
    this.func = func;
}

function ActionBar(id, action) {
    Panel.call(this, id);
    this.setStyle("float", "left");
    if (arguments.length > 1) {
        for (let i = 1; i < arguments.length; i++) {
            let button = new Button(i);
            button.setHeight("20px");
            button.setStyle("padding", "1px 1px 1px 1px");
            button.setStyle("font-size", "10px");
            button.setStyle("width", "44px")
            button.setText(arguments[i]["name"]);
            button.setOnclick(arguments[i]["func"]);
            this.add(button);
        }
    }
    this.setActions = function (actions) {
        if (actions.length > 0) {
            this.getComponent().innerHTML = '';
            for (let i = 0; i < actions.length; i++) {
                let button = new Button(i);
                button.setText(actions[i]["name"]);
                button.setOnclick(actions[i]["func"]);
                this.add(button);
            }
        }
    }
}
