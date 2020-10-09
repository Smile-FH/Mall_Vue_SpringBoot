$(function () {
    $("#jqGrid").jqGrid({
        url: '/admin/goods/list',
        datatype: "json",
        colModel: [
            { label: 'id', name: 'goodId', index: 'goodId', width: 50, key: true, hidden: true },
            { label: '分类id', name: 'categoryId', index: 'categoryId', width: 50, hidden: true },
            { label: '商品名称', name: 'goodName', index: 'goodName', width: 80 },
            { label: '商品简介', name: 'goodBrief', index: 'goodBrief', width: 80 },
            { label: '商品标签', name: 'goodTag', index: 'goodTag', width: 80, hidden: true },
            { label: '商品主图', name: 'goodMainImage', index: 'goodMainImage', width: 120, formatter: mainImageFormatter },
            { label: '商品轮播图', name: 'goodCarousel', index: 'goodCarousel', width: 80, hidden: true },
            { label: '商品详情', name: 'goodDetailContent', index: 'goodDetailContent', width: 80, hidden: true },
            { label: '商品原始售价', name: 'originalPrice', index: 'originalPrice', width: 80, hidden: true },
            { label: '商品售价', name: 'shellPrice', index: 'shellPrice', width: 80 },
            { label: '商品库存', name: 'goodInventory', index: 'goodInventory', width: 80 },
            { label: '商品是否上架', name: 'isShelves', index: 'isShelves', width: 60, align: 'center', formatter: shelveFormatter },
            { label: '商品添加时间', name: 'createTime', index: 'createTime', width: 120 },
            { label: '商品添加者id', name: 'createId', index: 'createId', width: 120, hidden: true },
            { label: '商品修改时间', name: 'updateTime', index: 'updateTime', width: 120, hidden: true },
            { label: '商品修改者id', name: 'updateId', index: 'updateId', width: 120, hidden: true }
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

    function mainImageFormatter(cellvalue) {
        return "<img src='" + cellvalue + "' height=\"120\" width=\"160\" alt='coverImage'/>";
    }

    function shelveFormatter(cellValue) {
        if (1 === cellValue) {
            return '<button type="button" class="btn btn-block btn-success btn-sm" style="width: 50%;">上架</button>';
        } else if (0 === cellValue) {
            return '<button type="button" class="btn btn-block btn-danger btn-sm" style="width: 50%;">下架</button>'
        }
    }
});

function editGood() {
    let id = getOneRowID();
    if (null === id) {
        return Swal.fire({
            icon: "warning",
            title: '操作通知',
            text: '选择一个商品先'
        });
    }
    window.location.href = '/admin/goodInfo?goodId=' + id;
}

function addGood() {
    window.location.href = '/admin/goodInfo'
}

function goodShelveStatus(statusNum) {
    let successResultCode = 200;
    let failResultCode = 500;
    let goodId = getOneRowID();
    let data = {
        goodId,
        isShelves: statusNum
    };
    let statusStr;
    if (null === goodId) {
        return Swal.fire({
            icon: "warning",
            title: "操作通知",
            text: "请先选择一个商品再进行此操作"
        })
    }
    if (0 === statusNum) {
        statusStr = '下架';
    } else if (1 === statusNum) {
        statusStr = '上架'
    }

    $.ajax({
        type: 'put',
        url: '/admin/goodInfo',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: res => {
            if (successResultCode === res.resultCode) {
                Swal.fire({
                    icon: "success",
                    title: statusStr + '通知',
                    text: '商品' + statusStr +'成功啦！'
                })
            } else if (failResultCode === res.resultCode) {
                Swal.fire({
                    icon: "error",
                    title: statusStr + '通知',
                    text: '未知原因' + statusStr + '失败啦！'
                })
            }
            reload();
        }
    })
}