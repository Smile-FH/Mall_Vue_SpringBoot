$(function () {
    $("#updateUserInfoButton").click(
        () => {
            // $("#updateUserInfoButton").attr("disabled",true);
            let nickName = $("#nickName").val();
            let oldPassword = $("#oldPassword").val();
            let newPassword = $("#newPassword").val();
            if (validUserNameForUpdate(nickName, oldPassword, newPassword)) {
                let params = $("#userInfoForm").serialize();
                $.ajax({
                    type: "POST",
                    url: "/admin/profile/modify",
                    data: params,
                    success: (result)=>{
                        if (result === "success") {
                            Swal.fire({
                                title: "修改成功"
                            }).then(result=>{
                                if (result) {
                                    window.location.href = "/admin/login";
                                }
                            });
                        } else {
                            Swal.fire({
                                title: result
                            });
                        }
                    }
                });
            }
        }
)
});

function validUserNameForUpdate(nickName, oldPassword, newPassword) {
    if (isNull(nickName) || validLength(nickName, 1)) {
        Swal.fire({
            title: "Nick Name不能为空"
        });
        return false;
    } else if (!validString(nickName)) {
        Swal.fire({
            title: "Nick Name格式不太对啊，只能输入2-10位的字母汉字或_、"
        });
        return false;
    }
    if (isNull(oldPassword) || validLength(oldPassword, 6)) {
        Swal.fire({
            title: "请输入您不低于6位的旧密码"
        });
        return false;
    }
    if (isNull(newPassword) || validLength(newPassword, 6)) {
        Swal.fire({
            title: "请输入您不低于6位的新密码"
        });
        return false;
    } else if (!validPassword(newPassword)) {
        Swal.fire({
            title: "新密码只能是6-18位的字母+数字"
        });
        return false;
    }
    return true;
}