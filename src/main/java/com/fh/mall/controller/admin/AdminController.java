package com.fh.mall.controller.admin;

import com.fh.mall.common.ServiceResultEnum;
import com.fh.mall.entity.AdminUser;
import com.fh.mall.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

}
