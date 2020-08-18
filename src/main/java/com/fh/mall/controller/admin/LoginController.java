package com.fh.mall.controller.admin;

import com.fh.mall.entity.AdminUser;
import com.fh.mall.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-11 10:04
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private AdminUserService adminUserService;

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
