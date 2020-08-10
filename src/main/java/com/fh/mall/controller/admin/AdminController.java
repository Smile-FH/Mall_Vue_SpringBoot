package com.fh.mall.controller.admin;

import com.fh.mall.entity.AdminUser;
import com.fh.mall.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-2 21:49
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/index")
    public String index(HttpServletRequest request){
        request.setAttribute("path","index");
        return "admin/index";
    }

    @GetMapping("/category")
    public String category(HttpServletRequest request){
        request.setAttribute("path","category");
        return "admin/category";
    }

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

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
    
    @PostMapping("/profile/modify")
    @ResponseBody
    public String modify(
            @RequestParam("loginUserName") String loginUserName,
            @RequestParam("oldLoginPassword") String oldLoginPassword,
            @RequestParam("newLoginPassword") String newLoginPassword,
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
                return "更新成功啦";
            case 2:
                return "原密码错误";
            default:
                System.out.println("其他情况除外");
        };
        return "全部执行完了，啥都没发生？？？少了一种情况吧？";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session){
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            System.out.println(attributeNames.nextElement());
        }
        session.removeAttribute("nickName");
        session.removeAttribute("adminUserId");
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

        AdminUser adminUser = adminUserService.login(loginUserName, loginPassword);
        System.out.println(adminUser.toString());
        if (adminUser != null) {
            session.setAttribute("nickName", adminUser.getNickName());
            session.setAttribute("adminUserId", adminUser.getAdminUserId());
            return "redirect:/admin/index";
        } else {
            session.setAttribute("errorMsg", "登录信息错误，请联系技术人员！");
        }
        return "redirect:/admin/login";
    }
    
}