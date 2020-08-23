/**
 *  判空验证
 * @param obj
 * @returns {boolean}
 */
function isNull(obj) {
    if (obj === null || obj === undefined || obj.trim() === "") {
        return true;
    }
}

/**
 * 参数长度验证
 * @param obj
 * @param length
 * @returns {boolean}
 */
function validLength(obj, length) {
    if (obj.trim().length < length) {
        return true;
    }
    return false;
}

/**
 * 判断2—10位汉字和字母用户名称
 * @param str
 * @returns {boolean}
 */
function validCN_ENString2_10(str) {
    let reg = /^[a-zA-Z0-9-\u4E00-\u9FA5_,、]{2,10}$/;
    if (reg.test(str.trim())) {
        return true;
    } else {
        return false;
    }
}

/**
 * 密码判断，只支持6-18位的字母+数字
 * @param password
 * @returns {boolean}
 */
function validPassword(password) {
    let reg = /^[a-zA-Z0-9]{6,18}$/;
    if (reg.test(password.trim())) {
        return true;
    }else {
        return false;
    }
}

/**
 * 刷新当前页操作
 */
function reload() {
    let page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        page: page
    }).trigger('reloadGrid');
}

/**
 * 获取当前时间yyyy-MM-dd HH:mm:ss格式
 * @param time
 * @returns {string}
 */
function time(time = +new Date()) {
    let date = new Date(time + 8 * 3600 * 1000); // 增加8小时
    return date.toJSON().substr(0, 19).replace('T', ' ');
}