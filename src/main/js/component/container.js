requires("/static/js/utils/utils.js").imports();
var COLLECT_TYPE_NORMAL = 0;
var COLLECT_TYPE_HIERARCHY = 1;
// 面板容器
function Panel(id) {
    Component.call(this, id, "div");
    this.component.setAttribute("id", id);
    this.datas = [];
    this.add = function (comp, before) {
        if (comp.isPacked !== undefined && comp.isPacked()) {
            if (before !== undefined) {
                this.component.insertBefore(comp.getComponent(), before);
            } else {
                this.component.appendChild(comp.getComponent());
            }
            if (comp.data !== undefined && comp.isInput()) {
                this.datas[this.datas.length] = comp;
                this.hasSub = true;
            }
            if (comp.hasSub !== undefined && comp.hasSub) {
                this.datas[this.datas.length] = comp;
                this.hasSub = true;
            }
        } else if (comp instanceof Node) {
            if (before !== undefined) {
                this.component.insertBefore(comp, before);
            } else {
                this.component.appendChild(comp);
            }
        }
        return this;
    };

    this.addRow = function (comp1, comp2, comp3, comp4) {
        let row = new RowPanel("");
        if (comp1 !== undefined) {
            row.add(comp1);
        }
        if (comp2 !== undefined) {
            row.add(comp2);
        }
        if (comp3 !== undefined) {
            row.add(comp3);
        }
        if (comp4 !== undefined) {
            row.add(comp4);
        }
        this.add(row);
    };

    this.collect = function (type) {
        if (type === undefined || type === null) {
            return this.collectData(this);
        } else if (type === COLLECT_TYPE_HIERARCHY) {
            return this.collectDataHierarchy(this);
        }
        return null;

    };

    this.collectJSON = function (type) {
        return JSON.stringify(this.collect(type));
    };

    // 收集数据对象
    this.collectData = function (comp) {
        let result = {};
        if (comp === undefined || comp === null) {
            comp = this;
        }
        if (comp.datas !== undefined && comp.datas !== null) {
            for (let index in comp.datas) {
                let dataComp = comp.datas[index];
                if (dataComp.data) {
                    let id = dataComp.getComponent().getAttribute("id");
                    if (id === null) {
                        id = dataComp.getComponent().getAttribute("name");
                    }
                    if (dataComp.collectData !== undefined) {
                        result[id] = dataComp.collectData();
                    } else {
                        result[id] = dataComp.getComponent().value;
                    }
                }
                if (dataComp.hasSub) {
                    let subResult = this.collectData(dataComp);
                    result = Object.assign(result, subResult);
                }
            }
        }
        return result;
    };

    // 收集数据对象
    this.collectDataHierarchy = function (comp) {
        let result = {};
        if (comp === undefined || comp === null) {
            comp = this;
        }
        if (comp.datas !== undefined && comp.datas !== null) {
            for (let index in comp.datas) {
                let dataComp = comp.datas[index];
                let id = dataComp.getComponent().getAttribute("id");
                if (id === null) {
                    id = dataComp.getComponent().getAttribute("name");
                }
                let value = null;

                if (dataComp.collectDataHierarchy !== undefined) {
                    value = dataComp.collectDataHierarchy();
                } else if (dataComp.collectData !== undefined) {
                    value = dataComp.collectData();
                } else if (dataComp.getComponent().value !== undefined) {
                    value = dataComp.getComponent().value;
                } else {
                    continue;
                }

                if (id === undefined || id === null || id.length === 0) {
                    result = merge(result, value);
                } else {
                    let existValue = result[id];
                    if (existValue !== undefined && existValue !== null) {
                        if (Array.isArray(existValue)) {
                            existValue.push(existValue);
                        } else {
                            result[id] = [];
                            result[id].push(existValue);
                        }
                        result[id].push(value);
                    } else {
                        if (dataComp.isArray()) {
                            let arr = [];
                            arr.push(value);
                            result[id] = arr;
                        } else {
                            result[id] = value;
                        }
                    }
                }
            }
        }
        return result;
    };

}

// 横向布局面板
function RowPanel(id) {
    Panel.call(this, id, "div");
    this.component.style.marginTop = '10px';

    let add = this.add;
    let that = this;

    //<br clear="all"> 清除float标签
    let clearTag = document.createElement("br");
    clearTag.setAttribute("clear", "all");
    this.component.appendChild(clearTag);

    this.add = function (comp) {
        comp.setStyle("float", "left");
        let lastChild = this.component.lastChild;
        add.call(this, comp, lastChild);
        let compHeight = document.defaultView.getComputedStyle(comp.getComponent(),null)["height"];
        let thisHeight = that.component.offsetHeight;
        if (compHeight > thisHeight) {
            that.component.style.height = compHeight + "px";
        }
        comp.getComponent().onresize = function () {
            that.getComponent().style.height = document.defaultView.getComputedStyle(comp.getComponent(),null)["height"] + "px";
        };
        return this;
    };

    this.adjust = function () {
        let children = this.component.children;
        if (children !== undefined && children !== null) {
            for (let child of children) {
                child.style.float = "left";
            }
        }
    };
}

function Tab(id) {
    Panel.call(this, id, "div");
}