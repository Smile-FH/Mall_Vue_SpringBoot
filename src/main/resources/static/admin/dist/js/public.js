let jQGrid = $('#jqGrid');

/**
 *  判空验证
 * @param obj
 * @returns {boolean}
 */
function isNull(obj) {
    if (null === obj || obj === undefined || "" === obj.trim()) {
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
    return obj.trim().length < length;

}

/**
 * 判断2—10位汉字和字母字符
 * @param str
 * @returns {boolean}
 */
function validCN_ENString2_10(str) {
    let reg = /^[a-zA-Z0-9-\u4E00-\u9FA5_,、-]{2,10}$/;
    return reg.test(str.trim());
}

/**
 * 密码判断，只支持6-18位的字母+数字
 * @param password
 * @returns {boolean}
 */
function validPassword(password) {
    let reg = /^[a-zA-Z0-9]{6,18}$/;
    return reg.test(password.trim());
}

/**
 * 刷新当前页操作
 */
function reload() {
    let page = jQGrid.jqGrid('getGridParam', 'page');
    jQGrid.jqGrid('setGridParam', {
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

/**
 * 获取jQGrid单行数据ID
 * @returns {jQuery}
 */
function getOneRowID() {
    return jQGrid.jqGrid('getGridParam', 'selrow');
}

/**
 * 获取jQGrid多行数据ID
 * @returns {jQuery}
 */
function getMoreRowsID() {
    return jQGrid.jqGrid('getGridParam', 'selarrrow');
}

/**
 * 获取jQGrid单行数据对象
 * @param id
 * @returns {jQuery}
 */
function getOneRowData(id) {
    return jQGrid.jqGrid('getRowData',id);
}

/**
 * 获得jQGrid多行数据对象
 * @param ids
 * @returns {[]}
 */
function getMoreRowsData(ids=[]) {
    let id;
    let oneRowData;
    let rowsData = [];
    for (id of ids){
        oneRowData = getOneRowData(id);
        rowsData.push(oneRowData);
    }
    return rowsData;
}