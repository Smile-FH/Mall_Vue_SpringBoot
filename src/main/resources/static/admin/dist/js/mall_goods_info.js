let editor;
$(function () {
    KindEditor.ready(K => {
        editor = K.create('#editor', {
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