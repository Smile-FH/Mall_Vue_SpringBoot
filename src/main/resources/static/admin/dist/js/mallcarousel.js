$(function () {
    $("#jqGrid").jqGrid({
        url: '/admin/carousels/list',
        datatype: "json",
        colModel: [
            { label: 'id', name: 'carouselId', index: 'carouselId', width: 50, key: true, hidden: true },
            { label: 'Image', name: 'carouselUrl', index: 'carouselUrl', width: 120, formatter: coverImageFormatter },
            { label: '跳转链接', name: 'redirectUrl', index: 'redirectUrl', width: 120 },
            { label: '排序值', name: 'carouselRank', index: 'carouselRank', width: 60, align: 'center' },
            { label: '是否删除', name: 'isDeleted', index: 'isDeleted', width: 60, hidden:true },
            { label: '注册时间', name: 'createTime', index: 'createTime', width: 60, hidden:true },
            { label: '注册人', name: 'createUser', index: 'createUser', width: 60, hidden:true },
            { label: '更新时间', name: 'updateTime', index: 'updateTime', width: 60, hidden:true },
            { label: '更新人', name: 'updateUser', index: 'updateUser', width: 60, hidden:true },
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
        gridComplete: function gridComplete() {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x": "hidden" });
        }

    });

    function coverImageFormatter(cellvalue) {
        return "<img src='" + cellvalue + "' height=\"120\" width=\"160\" alt='coverImage'/>";
    }


    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });
});

function addCarousel() {
    Swal.mixin({
        confirmButtonText: 'Next &rarr;',
        showCancelButton: true,
        progressSteps: ['1', '2', '3']
    }).queue([
        {
            input: 'file',
            title: '上传轮播图',
            inputValidator: file => {
                let suffix;
                let suffixIndex;
                let fileName;
                if (!file) {
                    return "请选择上传图片";
                }
                fileName = file.name;
                suffixIndex = fileName.lastIndexOf(".");
                suffix = fileName.substr(suffixIndex + 1);
                if (!/^(jpg|jpeg|png|gif)$/.test(suffix)) {
                    // alert('只支持jpg、png、gif格式的文件！');
                    return "只支持jpg、png、gif格式的文件！";
                }
            },
        },
        {
            title: '请输入跳转地址',
            input: 'url',
            inputValidator: value => {
                let regExp = "^(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-Z0-9\\.&%\\$\\-]+)*@)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4})(\\:[0-9]+)?(/[^/][a-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$#\\=~_\\-@]*)*$";
                let exp = new RegExp(regExp);
                if (!exp.test(value)) {
                    return "URL不正确啊！";
                }
            },
        },
        {
            input: 'text',
            title: "排序值",
            inputValidator: value => {
                let result = Number(value);
                if (!result) {
                    return "排序值只能是数字偶！";
                }
            }
        }
    ]).then((result) => {
        let carouselRank;
        let redirectUrl;
        let formData = new FormData();
        formData.append("file", result.value[0]);
        redirectUrl = result.value[1];
        carouselRank = result.value[2];
        $.ajax({
            type: "POST",
            url: "/upload/file",
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: result => {
                if (200 === result.resultCode ){
                    let map = {
                        carouselUrl: result.data,
                        redirectUrl: redirectUrl,
                        carouselRank: carouselRank
                    };
                    let data = JSON.stringify(map);

                    $.ajax({
                        type: "post",
                        url: "/admin/carousel/save",
                        contentType: "application/json",
                        data:data,
                        success: result=>{
                            if (200 === result.resultCode) {
                                Swal.fire({
                                    icon: "success",
                                    text: "亲，你添加成功了诶！"
                                }).then(value => {
                                    if (value.isConfirmed){
                                        reload()
                                    }
                                })
                            }
                        }
                    })
                }
            }
        })
    })
}

function delCarousel() {
    let ids = $("#jqGrid").jqGrid('getGridParam', 'selarrrow');
    if (0 === ids.length) {
        return;
    }
    Swal.fire({
        icon: "warning",
        title: "删除操作",
        text: "Are You Sure？",
        showCancelButton: true
    }).then(result => {
        if (result.isConfirmed) {
            $.ajax({
                type: "POST",
                url: "/admin/carousel/deleted",
                contentType: "application/json",
                data: JSON.stringify(ids),
                success: result => {
                    if (result.resultCode === 200) {
                        Swal.fire({
                            icon: "success",
                            title: "Deleted!",
                            text: "Your file has been deleted!"
                        }).then(value => {
                            if (value.isConfirmed) {
                                reload();
                            }
                        })
                    }
                }
            });
        }
    });
}

function updateCarousel() {
    let ids = $("#jqGrid").jqGrid('getGridParam', 'selarrrow');
    let data = $("#jqGrid").jqGrid('getRowData', ids);
    if (ids.length === 0) {
        return;
    }
    if (ids.length > 1) {
        Swal.fire({
            icon: "error",
            title: "亲，一次只能更改一条记录呦"
        });
        return;
    }

    Swal.mixin({
        confirmButtonText: 'Next &rarr;',
        showCancelButton: true,
        progressSteps: ['1', '2']
    }).queue([
        {
            title: '修改跳转地址',
            input: 'url',
            inputValue: data.redirectUrl,
            inputValidator: value => {
                let regExp = "^(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-Z0-9\\.&%\\$\\-]+)*@)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4})(\\:[0-9]+)?(/[^/][a-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$#\\=~_\\-@]*)*$";
                let exp = new RegExp(regExp);
                if (!exp.test(value)) {
                    return "URL不正确啊！";
                }
            },
        }, {
            title: '排序值',
            input: 'text',
            inputValue: data.carouselRank,
            inputValidator: value => {
                let result = Number(value);
                if (!result) {
                    return "排序值只能是数字偶！";
                } else if (999999 < result) {
                    return "排序值数字只能是六位以下偶！"
                }
            }
        }
    ]).then((result) => {
        let answers;
        let map = {
            redirectUrl: result.value[0],
            carouselRank: result.value[1],
            carouselId: data.carouselId,
            updateTime: time()
        };
        if (result.value) {
            answers = JSON.stringify(map);
            $.ajax({
                type: "post",
                url: "/admin/carousel/update",
                contentType: "application/json",
                data: answers,
                success: result=> {
                    if (result.resultCode === 200) {
                        Swal.fire({
                            icon: "success",
                            title: "修改成功啦！"
                        }).then(value => {
                            if (value.isConfirmed) {
                                reload();
                            }
                        })
                    } else {
                        Swal.fire({
                            icon: "error",
                            title: "哎呀呀，错了呢，一会儿再试试吧"
                        })
                    }
                }
            })
        }
    })

}