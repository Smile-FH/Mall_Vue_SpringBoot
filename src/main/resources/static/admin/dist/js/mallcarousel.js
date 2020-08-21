$(function () {
    $("#jqGrid").jqGrid({
        url: '/admin/carousels/list',
        datatype: "json",
        colModel: [
            { label: 'id', name: 'carouselId', index: 'carouselId', width: 50, key: true, hidden: true },
            { label: 'Url', name: 'carouselUrl', index: 'carouselUrl', width: 120 },
            { label: '点击Url', name: 'redirectUrl', index: 'redirectUrl', width: 120 },
            { label: '排序值', name: 'carouselRank', index: 'carouselRank', width: 60, align: 'center' },
            { label: '是否删除', name: 'isDeleted', index: 'isDeleted', width: 60 },
            { label: '注册时间', name: 'createTime', index: 'createTime', width: 60 },
            { label: '注册人', name: 'createUser', index: 'createUser', width: 60 },
            { label: '更新时间', name: 'updateTime', index: 'updateTime', width: 60 },
            { label: '更新人', name: 'updateUser', index: 'updateUser', width: 60 },
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

    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });
});

function addCarousel() {
    Swal.mixin({
        input: 'file',
        confirmButtonText: 'Next &rarr;',
        showCancelButton: true,
        progressSteps: ['1', '2', '3']
    }).queue([
        {
            title: '上传轮播图',
        },
        {
            title: '请输入跳转地址',
            input: 'url'
        },{
            title: '排序值',
            input: 'text'
        }
    ]).then((result) => {
        if (result.value) {
            const answers = JSON.stringify(result.value);
            Swal.fire({
                title: 'All done!',
                html: `
        Your answers:
        <pre><code>${answers}</code></pre>
      `,
                confirmButtonText: 'Lovely!'
            })
        }
    })
}