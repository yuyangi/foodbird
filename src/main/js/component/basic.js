requires('/static/js/component/component.js').imports();
// 按钮
function Button(id, text) {
    Component.call(this, id, "button");
    this.component.setAttribute("type", "button");
    this.setText = function (text) {
        this.component.innerText = text;
    };

    if (text !== undefined) {
        this.setText(text);
    }

    this.setOnclick = function (func) {
        this.clickAction = func;
        this.component.addEventListener('click', func);
    };

    this.getOnclick = function () {
        return this.clickAction;
    };
}

// 标签
function Label(id, text) {
    Component.call(this, id, "span");
    this.component.setAttribute("id", id);
    this.component.setAttribute("class", "label");
    this.component.innerText = text;
    this.setText = function (text) {
        this.component.innerText = text;
    };
}

// 文本框
function TextField(id) {
    Component.call(this, id, "input");
    this.component.setAttribute("type", "text");
    this.data = true;
    this.setText = function (text) {
        this.component.value = text;
    };
}

function Select(id) {
    Component.call(this, id, "select");
    this.data = true;

    this.setItems = function (items) {
        this.component.options.length = 0;
        for (let i = 0; i < items.length; i++) {
            this.component.options.add(new Option(items[i].name,items[i].id));
        }
        if (this.component.selectedIndex < 0 && this.component.options.length > 0) {
            this.component.options[0].selected = true;
        }
        this.dispatchEvent("change");
    };

    this.setSelected = function (value) {
        for (let i = 0; i < this.component.options.length; i++) {
            let option = this.component.options[i];
            if (option.value === value) {
                option.selected = true;
                break;
            }
        }
    };

    this.clear = function () {
        this.component.options.length = 0;
    };

    this.load = function (loadFunc) {
        let items = loadFunc();
        this.setItems(items);
    };

    this.getValue = function () {
        let index = this.component.selectedIndex;
        let selectedOpt = this.component.options[index];
        return selectedOpt.value;
    };


    this.getSelected = function () {
        let index = this.component.selectedIndex;
        if (index !== undefined && index >= 0) {
            return this.component.options[index];
        }
        return null;
    };

    this.getSelectedValue = function () {
        let index = this.component.selectedIndex;
        if (index !== undefined && index >= 0) {
            return this.component.options[index].value;
        }
        return null;
    };

    this.getSelectedText = function () {
        let index = this.component.selectedIndex;
        if (index !== undefined && index >= 0) {
            return this.component.options[index].text;
        }
        return null;
    };

    this.valueChange = function (valueChange) {
        this.valueChangeAction = valueChange;
        this.getComponent().onchange = this.valueChangeAction;
    };
}

function TextArea(id) {
    Component.call(this, id, "textarea");
    this.data = true;
    this.setText = function (text) {
        this.component.value = text;
    };
}

function CheckboxButton(id, value) {
    Component.call(this, id, "input");
    this.setAttribute("type", "checkbox");
    if (value !== undefined) {
        this.component.value = value;
    }

    this.setValue = function (value) {
        this.component.value = value;
    };

    this.setChecked = function (checked) {
        this.component.checked = checked;
    };

    this.isChecked = function () {
        return this.component.checked;
    };
}

function RadioButton(id, value) {
    Component.call(this, id, "input");
    this.setAttribute("type", "radio");
    if (value !== undefined) {
        this.component.value = value;
    }

    this.setValue = function (value) {
        this.component.value = value;
    };

    this.setChecked = function (checked) {
        this.component.checked = checked;
    };

    this.isChecked = function () {
        return this.component.checked;
    };
}

function Checkbox(id, text, value) {
    Component.call(this, id, "div");
    this.checkboxButton = new CheckboxButton(id, value);
    this.add(this.checkboxButton);
    if (text !== undefined && text !== null) {
        this.getComponent().innerHTML = this.checkboxButton.getComponent().outerHTML + text;
    }

    this.setValue = function (value) {
        this.checkboxButton.setValue(value);
    };

    this.setChecked = function (checked) {
        this.checkboxButton.setChecked(checked);
    };

    this.isChecked = function () {
        return this.checkboxButton.isChecked();
    };

    this.setText = function (text) {
        this.getComponent().innerHTML = this.checkboxButton.getComponent().outerHTML + text;
    };

    this.getCheckboxButton = function () {
        return this.checkboxButton;
    };
}

function Radio(id, text, value) {
    Component.call(this, id, "label");
    let radioButton = new RadioButton(id, value);
    this.add(radioButton);
    this.getComponent().innerText = text;

    this.setValue = function (value) {
        radioButton.setValue(value);
    };

    this.setChecked = function (checked) {
        radioButton.setChecked(checked);
    };

    this.isChecked = function () {
        return radioButton.isChecked();
    };

    this.setText = function (text) {
        this.getComponent().innerText = text;
    };
}