package com.fh.mall.controller.admin;

import com.fh.mall.common.ServiceResultEnum;
import com.fh.mall.entity.AdminUser;
import com.fh.mall.service.AdminUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 管理员用户的控制层处理
 * @Author HueFu
 * @Date 2020-8-2 21:49
 */
@Controller
@Api(tags = {"管理员后台页面跳转，修改管理员数据，登录，登出接口"})
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;

    @ApiOperation(value = "后台首页跳转")
    @GetMapping("/index")
    public String index(HttpServletRequest request){
        request.setAttribute("path","index");
        return "admin/index";
    }

    @ApiOperation(value = "后台管理员个人信息页跳转")
    @GetMapping("/profile")
    public String profile(HttpServletRequest request){
        int loginUserId = (int)request.getSession().getAttribute("adminUserId");
        AdminUser adminUserDetailByID = adminUserService.getAdminUserDetailByID(loginUserId);
        if (adminUserDetailByID == null) {
            return "admin/login";
        }
        request.setAttribute("path","profile");
        request.setAttribute("loginUserName", adminUserDetailByID.getLoginUserName());
        request.setAttribute("nickName",adminUserDetailByID.getNickName());
        return "admin/profile";
    }

    @ApiOperation(value = "后台管理员个人信息修改", notes = "account、password、nickname")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "登录管理员的账号主体"),
            @ApiImplicitParam(name = "oldPassword", value = "修改前的密码")
    })
    @PostMapping("/profile/modify")
    @ResponseBody
    public String modify(
            @RequestParam("account") String loginUserName,
            @RequestParam("oldPassword") String oldLoginPassword,
            @RequestParam("newPassword") String newLoginPassword,
            @RequestParam("nickName") String nickName,
            HttpServletRequest request){
        if (StringUtils.isEmpty(loginUserName)){
            return "Account不能为空";
        } else
        if (StringUtils.isEmpty(oldLoginPassword)){
            return "Old Password不能为空";
        } else
        if (StringUtils.isEmpty(newLoginPassword)){
            return "New Password不能为空";
        } else
        if (StringUtils.isEmpty(nickName)){
            return "Nick Name不能为空";
        }
        if (oldLoginPassword.equals(newLoginPassword)) {
            return "新密码不能和旧密码相同";
        }
        int adminUserId = (int)request.getSession().getAttribute("adminUserId");
        int i = adminUserService.changeAdminUserInfo(loginUserName, oldLoginPassword, newLoginPassword, nickName, adminUserId);
        switch (i){
            case 0:
                return "执行出错啦";
            case 1:
//                更新成功时需要清除session会话遗留的信息，前端控制跳转到登录页
                request.getSession().removeAttribute("adminUserId");
                request.getSession().removeAttribute("nickName");
                request.getSession().removeAttribute("errorMsg");
                return ServiceResultEnum.SUCCESS.getResult();
            case 2:
                return "原密码错误";
            default:
                System.out.println("其他情况除外");
        };
        return "全部执行完了，啥都没发生？？？少了一种情况吧？";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("nickName");
        session.removeAttribute("adminUserId");
        return "admin/login";
    }

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String signin(
            @RequestParam("loginUserName") String loginUserName,
            @RequestParam("loginPassword") String loginPassword,
            @RequestParam("verifyCode") String verifyCode,
            HttpSession session){
        if (StringUtils.isEmpty(verifyCode)){
            session.setAttribute("errorMsg", "验证码不能为空");
            return "redirect:/admin/login";
        }

        if (StringUtils.isEmpty(loginUserName) || StringUtils.isEmpty(loginPassword)){
            session.setAttribute("errorMsg", "用户账户和密码不能为空");
            return "redirect:/admin/login";
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)){
            session.setAttribute("errorMsg", "验证码错误");
            return "redirect:/admin/login";
        }

        AdminUser loginUser = adminUserService.login(loginUserName, loginPassword);

        if (loginUser != null) {
            session.setAttribute("nickName", loginUser.getNickName());
            session.setAttribute("adminUserId", loginUser.getAdminUserId());
            return "redirect:/admin/index";
        } else {
            session.setAttribute("errorMsg", "也许是你账号或密码错了趴！");
        }
        return "redirect:/admin/login";
    }


}
