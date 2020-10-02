let categoryLevel = $("#categoryLevel").val();
let parentId = $("#parentId").val();
let backParentId = $("#backParentId").val();

$(function () {
    $("#jqGrid").jqGrid({
        url: '/admin/category/list?categoryLevel=' + categoryLevel + '&parentId=' + parentId,
        datatype: "json",
        colModel: [
            { label: '分类id', name: 'categoryId', index: 'categoryId', width: 50, key: true, hidden: true },
            { label: '分类级别', name: 'categoryLevel', index: 'categoryLevel', width: 80, hidden: true },
            { label: '分类父级id', name: 'parentId', index: 'parentId', width: 100, hidden: true },
            { label: '分类名称', name: 'categoryName', index: 'categoryName', width: 100 },
            { label: '分类排序值', name: 'categoryRank', index: 'categoryRank', width: 100, hidden: true },
            {
                label: '是否已删除',
                name: 'isDeleted',
                index: 'isDeleted',
                width: 60,
                align: 'center',
                formatter: deleteFormatter
            },
            { label: '添加者id', name: 'createId', index: 'createId', width: 120, hidden: true },
            { label: '添加时间', name: 'createTime', index: 'createTime', width: 120, hidden: true },
            { label: '分类信息更新者id', name: 'updateId', index: 'updateId', width: 120, hidden: true },
            { label: '分类信息更新时间', name: 'updateTime', index: 'updateTime', width: 120, hidden: true }
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

    function deleteFormatter(cellValue) {
        if (cellValue === 0) {
            return '<button type="button" class="btn btn-block btn-success btn-sm" style="width: 50%;">正常</button>';
        } else if (cellValue === 1) {
            return '<button type="button" class="btn btn-block btn-danger btn-sm" style="width: 50%;">注销</button>'
        }
    }
});

/**
 * 增加新的分类
 * @author Hue_Fu
 */
function addGoodsCategory() {
    Swal.mixin({
        confirmButtonText: 'Next &rarr;',
        showCancelButton: true,
        progressSteps: ['1', '2']
    }).queue([
        {
            title: '添加分类名称',
            input: 'text',
            inputValidator: value => {
                if (!validCN_ENString2_10(value)) {
                    return '2-10位中英文字符';
                }
            },
        }, {
            title: '排序值',
            input: 'text',
            inputValidator: value => {
                let result = Number(value);
                if (!result) {
                    return "排序值只能是数字偶！";
                } else if (999999 < result) {
                    return "排序值数字只能是七位以下偶！"
                }
            }
        }
    ]).then(result => {
        let value = result.value;
        let data = {
            categoryLevel,
            parentId,
            categoryName: value[0],
            categoryRank: value[1],
        };
        $.ajax({
            type: 'post',
            async: false,
            url: '/admin/category',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: res => {
                reload();
            }
        })
    })
}

/**
 * 修改分类数据
 */
function editCategoryInfo() {
    // 1. 修改名称
    // 2. 修改排序值

    let rowData;
    let rowId = getOneRowID();
    if (null == rowId) {
        return Swal.fire({
            icon: "info",
            title: "修改提示",
            text: "请先选择一个分类",
        })
    }
    rowData = getOneRowData(rowId);
    Swal.mixin({
        confirmButtonText: 'Next &rarr;',
        showCancelButton: true,
        progressSteps: ['1', '2']
    }).queue([
        {
            title: '修改分类名称',
            input: 'text',
            inputValue: rowData.categoryName,
            inputValidator: value => {
                if (!validCN_ENString2_10(value)) {
                    return '2-10位中英文字符';
                }
            },
        }, {
            title: '修改排序值',
            input: 'text',
            inputValue: rowData.categoryRank,
            inputValidator: value => {
                let result = Number(value);
                if (!result) {
                    return "排序值只能是数字偶！";
                } else if (999999 < result) {
                    return "排序值数字只能是七位以下偶！"
                }
            }
        }
    ]).then(r => {
        let editValue = r.value;
        let data = {
            categoryId: rowId,
            categoryLevel,
            parentId,
            categoryName: editValue[0],
            categoryRank: editValue[1]
        };
        $.ajax({
            type: 'put',
            async: false,
            url: '/admin/category',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: res => {
                reload()
            }
        })
    })

}

/**
 * 下级目录
 */
function nextLevel() {
    let rowData;
    let rowId = getOneRowID();
    if (null === rowId) {
        return Swal.fire({
            icon: "warning",
            title: "温馨提示",
            text: "请选择一个分类",
        })
    }
    if ('1' === categoryLevel || '2' === categoryLevel) {
        categoryLevel++;
    } else {
        return Swal.fire({
            icon: "info",
            title: "温馨提示",
            text: "没有下级分类了呀！",
        })
    }

    rowData = getOneRowData(rowId);
    parentId = rowData.parentId;

    window.location.href =
        window.location.pathname +
        '?categoryLevel=' + categoryLevel
        + '&parentId=' + rowId
        + '&backParentId=' + parentId;
}

/**
 * 上级目录
 */
function upLevel() {
    if ('2' === categoryLevel || '3' === categoryLevel) {
        categoryLevel--;
    } else {
        return Swal.fire({
            icon: "info",
            title: "温馨提示",
            text: "没有父级分类了呀！",
        })
    }
    window.location.href =
        window.location.pathname +
        '?categoryLevel=' + categoryLevel
        + '&parentId=' + backParentId
        + '&backParentId=' + 0;
}