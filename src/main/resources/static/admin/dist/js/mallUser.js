$(function () {
    $("#jqGrid").jqGrid({
        url: '/admin/users/list',
        datatype: "json",
        colModel: [
            { label: 'id', name: 'userId', index: 'userId', width: 50, key: true, hidden: true },
            { label: '昵称', name: 'nickName', index: 'nickName', width: 80 },
            { label: '登录名', name: 'loginName', index: 'loginName', width: 100 },
            { label: '身份状态', name: 'lockedFlag', index: 'lockedFlag', width: 60, align: 'center', formatter: lockedFormatter },
            { label: '是否注销', name: 'isDeleted', index: 'isDeleted', width: 60, align: 'center', formatter: deleteFormatter },
            { label: '注册时间', name: 'createTime', index: 'createTime', width: 120 }
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
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x": "hidden" });
        }
    });

    /**
     * 设置autowidth时，需要在触发浏览器窗口改变时触发setGridWidth函数
     */
    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });

    function lockedFormatter(cellValue, options, rowObject) {
        if (cellValue === 0) {
            return '<button type="button" class="btn btn-block btn-sm btn-success" style="width: 50%;">正常</button>';
        } else if (cellValue === 1) {
            return '<button type="button" class="btn btn-block btn-sm btn-warning" style="width: 50%;">锁定</button>';
        }
    }

    function deleteFormatter(cellValue) {
        if (cellValue === 0) {
            return '<button type="button" class="btn btn-block btn-success btn-sm" style="width: 50%;">正常</button>';
        } else if (cellValue === 1) {
            return '<button type="button" class="btn btn-block btn-danger btn-sm" style="width: 50%;">注销</button>'
        }
    }

});

function lockUser(lockStatus) {
    let ids = $('#jqGrid').jqGrid('getGridParam', 'selarrrow');
    if (ids.length === 0) {
        return;
    }

    if (lockStatus !== 0 && lockStatus !== 1) {
        Swal.fire({
            title: '非法操作',
            icon: 'error'
        })
    }
    Swal.fire({
        icon: "warning",
        title: "确认弹框",
        text: "亲，你确定要修改账号状态么？",
        confirmButtonText: "鹅···，确定！",
        cancelButtonText: "算了，饶了他吧",
        showCancelButton: true
    }).then(result => {
        if (result.isConfirmed) {
            $.ajax({
                type: "post",
                url: "/admin/users/lock/" + lockStatus,
                contentType: "application/json",
                data: JSON.stringify(ids),
                success: (result) => {
                    if (result.resultCode === 200) {
                        Swal.fire({
                            icon: "success",
                            title: "返回信息",
                            text: "Perfect, 删除成功了啊！"
                        }).then(result => {
                            if (result) {
                                reload();
                            }
                        });
                    } else {
                        Swal.fire({
                            icon: "error",
                            title: "服务器出错了",
                            text: result.message
                        })
                    }
                }
            });
        }
    })
}