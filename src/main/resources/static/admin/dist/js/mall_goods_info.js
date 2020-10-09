let editor;
$(function () {
    KindEditor.ready(K => {
        editor = K.create('#goodDetail', {
            items: [
                'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
                'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                'anchor', 'link', 'unlink', '|', 'about'
            ],
            uploadJson: '/upload/file',
            filePostName: 'file'
        });
    });

    new AjaxUpload('#uploadGoodsCoverImg', {
        action: '/upload/file',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                Swal.fire({
                    icon: "error",
                    text: '只支持jpg、png、gif格式的文件！'
                });
                return false;
            }
        },
        onComplete: (file, r) => {
            if (r != null && r.resultCode == 200) {
                $("#goodsCoverImg").attr("src", r.data);
                $("#goodsCoverImg").attr("style", "width: 128px;height: 128px;display:block;");
                return false;
            } else {
                Swal.fire({
                    icon: 'error',
                    title: '上传出错啦！',
                    text: '未知原因上传出错，请联系管理员！'
                })
            }
        }
    });
    let a = $('#goodInfo').val();
    console.log(a);
});

function getList(str = '') {
    $.ajax({
        type: 'get',
        url: '/admin/goodInfo/levelList?categoryId=' + $(str).val(),
        contentType: 'application/json',
        success: res => {
            let thirdList;
            let secondList;
            if (res.data) {
                if ('#levelOne' == str) {
                    thirdList = res.data.thirdList;
                    secondList = res.data.secondList;
                    addOption('#levelTwo', secondList);
                    addOption('#levelThree', thirdList);
                } else if ('#levelTwo' == str) {
                    thirdList = res.data.thirdList;
                    addOption('#levelThree', thirdList);
                }
            }
        }
    })
}

function addOption(str = '', list = []) {
    let i;
    $(str).empty();
    for (i = 0; i < list.length; i++) {
        $(str).append('<option value="' + list[i].categoryId + '">' + list[i].categoryName + '</option>');
    }
}

function saveGood() {
    let successResultCode = 200;
    let failResultCode = 500;
    let data;
    let type;
    let successResultMessage;
    let failResultMessage;
    let titleText;
    let goodId = $('#goodInfo').val();
    let goodName = $('#goodName').val();
    let goodBrief = $('#goodBrief').val();
    let goodOriginalPace = $('#goodOriginalPace').val();
    let goodShellPace = $('#goodShellPace').val();
    let goodInventory = $('#goodInventory').val();
    let goodTag = $('#goodTag').val();
    let categoryId = $('#levelThree').val();
    let goodDetail = editor.html();
    let isShelves = $('input[name=goodsSellStatus]:checked').val();
    let goodCoverImg = $('#goodsCoverImg')[0].src;
    if (isNull(goodCoverImg) || -1 !== goodCoverImg.indexOf('user3-128x128')) {
        return Swal.fire({
            icon: 'error',
            text: '请先上传图片'
        })
    }
    data = {
        goodName,
        goodBrief,
        originalPrice: goodOriginalPace,
        shellPrice: goodShellPace,
        goodInventory,
        goodTag,
        categoryId,
        isShelves,
        goodDetailContent: goodDetail,
        goodMainImage: goodCoverImg,
        goodCarousel: goodCoverImg
    };
    if (0 < goodId) {
        type = 'put';
        data.goodId = goodId;
        titleText = '修改信息结果';
        successResultMessage = '修改商品信息成功！';
        failResultMessage = '修改商品信息失败，请联系运维人员！';
    } else {
        type = 'post';
        titleText = '添加商品结果';
        successResultMessage = '添加商品信息成功！';
        failResultMessage = '添加新商品失败，请联系运维人员！';
    }
    // console.log('goodName: ', goodName,
    //     '\ngoodBrief:', goodBrief,
    //     '\ngoodOriginalPace:',goodOriginalPace,
    //     '\ngoodShellPace',goodShellPace,
    //     '\ngoodInventory', goodInventory,
    //     '\ngoodTag', goodTag,
    //     '\ngoodDetail', goodDetail,
    //     '\ncategoryId', categoryId,
    //     '\nisShelves', isShelves,
    //     '\ngoodCoverImg', goodCoverImg);


    $.ajax({
        type,
        url: '/admin/goodInfo',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: res => {
            console.log(res);
            $('#modal-lg').modal('hide');
            if (successResultCode === res.resultCode) {
                Swal.fire({
                    icon: "success",
                    title: titleText,
                    text: successResultMessage
                })
            } else if (failResultCode === res.resultCode){
                Swal.fire({
                    icon: "error",
                    title: titleText,
                    text: failResultMessage
                })
            }
            reload();
        }
    })
}

function verifyParam() {
    let mapKey;
    let i;
    let goodName = $('#goodName').val();
    let goodBrief = $('#goodBrief').val();
    let goodOriginalPace = $('#goodOriginalPace').val();
    let goodShellPace = $('#goodShellPace').val();
    let goodInventory = $('#goodInventory').val();
    let goodTag = $('#goodTag').val();
    let categoryId = $('#levelThree').val();
    let isShelves = $('input[name=goodsSellStatus]:checked').val();
    let goodDetail = editor.html();
    let obj = [goodName, goodBrief, goodOriginalPace, goodShellPace, goodInventory, goodTag, categoryId, isShelves, goodDetail];
    let str = ['goodName', 'goodBrief', 'goodOriginalPace', 'goodShellPace', 'goodInventory', 'goodTag', 'categoryId', 'isShelves', 'goodDetail'];
    let zhStr = ['商品名称', '商品简介', '商品原始价格', '商品售卖价格', '商品库存数', '商品标签', '分类', '上架状态', '商品详情'];
    let map = new Map();
    for (i = 0; i < obj.length; i++) {
        map.set(zhStr[i], obj[i]);
    }
    for (mapKey of map) {
        if (isNull(mapKey[1])) {
            return Swal.fire({
                icon: "error",
                text: mapKey[0] + '不能为空请再填一填'
            })
        }
    }
    $('#modal-lg').modal('show');
}