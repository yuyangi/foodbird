/**
 * 合并两个对象，将值放到第一个对象中
 * 如果两个对象中有相同的属性，则该属性被合并后变成一个数组对象
 * @param target
 * @param source
 * @returns {*}
 */
function merge(target, source) {
    if ($.isEmptyObject(target)) {
        return Object.assign(target, source);
    }
    if ($.isEmptyObject(source)) {
        return target;
    }
    for (let key in target) {
        for (let skey in source) {
            if (key === skey) {
                let targetElement = target[key];
                let sourceElement = source[skey];
                if (Array.isArray(targetElement)) {
                    targetElement.push(sourceElement);
                } else {
                    target[key] = [];
                    if (targetElement !== null) {
                        target[key].push(targetElement);
                    }
                    target[key].push(sourceElement);
                }
            } else {
                target[skey] = source[skey];
            }
        }
    }
    return target;
}

/**
 * 合并两个对象，将值放到第一个对象中
 * 重复的属性source覆盖target
 * @param target
 * @param source
 * @returns {any}
 */
function assign(target, source) {
    return Object.assign(target, source);
}