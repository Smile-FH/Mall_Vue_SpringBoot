$(function () {
    $("#jqGrid").jqGrid({
        url: '/users/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'userId', index: 'userId', width: 50, key: true},
            {label: '昵称', name: 'nickName', index: 'nickName', width: 80},
            {label: '登录名', name: 'loginName', index: 'loginName', width: 100},
            {label: '身份状态', name: 'lockedFlag', index: 'lockedFlag', width: 60, align:'center'},
            {label: '是否注销', name: 'isDeleted', index: 'isDeleted', width: 60},
            {label: '注册时间', name: 'createTime', index: 'createTime', width: 120}
        ],
        height: 450,
        rowNum: 10,
        rowList: [10, 30, 50],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: true,
        rownumWidth: 35,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",

        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });

    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });
});