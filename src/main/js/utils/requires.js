
let reqModules = [];

function requires() {
    for (let arg in arguments) {
        let m = arguments[arg];
        let isExist = false;
        for (let exist in reqModules) {
            if (reqModules[exist]["module"] === m) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            reqModules.push({module: m, isImported: false});
        }
    }

    this.imports = function () {
        for (let module of reqModules) {
            if (!module.isImported) {
                document.write("<script type='text/javascript' language=javascript src='"+module.module+"'></script>");
                module.isImported = true;
            }
        }
    };
    return this;
}
