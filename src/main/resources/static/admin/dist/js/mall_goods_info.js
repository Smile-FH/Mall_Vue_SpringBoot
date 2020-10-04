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
            uploadJson: '/admin/upload/file',
            filePostName: 'file'
        });
    });
});

function getList(str = '') {
    $.ajax({
        type: 'get',
        url: '/admin/goods/levelList?categoryId=' + $(str).val(),
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

function addOption( str= '', list = []) {
    let i;
    $(str).empty();
    for (i = 0; i < list.length; i++) {
        $(str).append('<option value="' + list[i].categoryId + '">' + list[i].categoryName + '</option>');
    }
}

function saveGood() {
    // 还缺一个是否上架的属性
    // 图片上传的功能也没搞定
    let data;
    let goodName = $('#goodName').val();
    let goodBrief = $('#goodBrief').val();
    let goodOriginalPace = $('#goodOriginalPace').val();
    let goodShellPace = $('#goodShellPace').val();
    let goodInventory = $('#goodInventory').val();
    let goodTag = $('#goodTag').val();
    let categoryId = $('#levelThree').val();
    let goodDetail = editor.html();
    console.log('goodName: ', goodName,
        '\ngoodBrief:', goodBrief,
        '\ngoodOriginalPace:',goodOriginalPace,
        '\ngoodShellPace',goodShellPace,
        '\ngoodInventory', goodInventory,
        '\ngoodTag', goodTag,
        '\ngoodDetail', goodDetail,
        '\ncategoryId', categoryId);

    data = {
        goodName,
        goodBrief,
        originalPrice: goodOriginalPace,
        shellPrice: goodShellPace,
        goodInventory,
        goodTag,
        categoryId,
        goodDetailContent: goodDetail
    };

    $.ajax({
        type: 'post',
        url: '/admin/goods',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: res => {
            console.log(res);
        }
    })

}