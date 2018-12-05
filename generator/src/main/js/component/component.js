/**
 * 基础控件
 * @param id 控件id
 * @param tag 控件对应html标签
 * @constructor
 */

function Component(id, tag) {
    this.component = document.createElement(tag);
    this.component.setAttribute("id", id);
    this.component.setAttribute("name", id);
    this.packed = true;
    this.isInput = false;
    this.hasSub = false;
    this.array = false;
    this.setAttribute = function (type, value) {
        this.component.setAttribute(type, value);
    };

    this.setStyle = function (style, value) {
        this.component.style.setProperty(style, value);
    };

    this.setCss = function (cssName) {
        this.component.className = cssName;
    };

    this.getComponent = function () {
        return this.component;
    };

    this.setBackground = function (background) {
        this.setStyle("background", background);
    };

    this.setWidth = function (width) {
        this.component.style.width = width;
    };

    this.setHeight = function (height) {
        this.component.style.height = height;
    };

    this.isPacked = function () {
        return this.packed;
    };

    this.setPacked = function (isPacked) {
        this.packed = isPacked;
    };

    this.setName = function (name) {
        this.component.name = name;
    };

    this.isInput = function () {
        return this.isInput;
    };

    this.setName = function (name) {
        this.component.setAttribute("name", name);
    };

    this.add = function (comp) {
        this.component.appendChild(comp.getComponent());
    };

    this.setArray = function (isArray) {
        this.array = isArray;
    };

    this.isArray = function () {
        return this.array;
    };

    this.dispatchEvent = function (eventName) {
        let evt = document.createEvent('Event');
        evt.initEvent(eventName, true, true);
        this.getComponent().dispatchEvent(evt);
    };
}
