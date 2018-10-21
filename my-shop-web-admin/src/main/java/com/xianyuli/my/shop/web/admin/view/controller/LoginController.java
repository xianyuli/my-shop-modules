package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.utils.ConstantUtils;
import com.xianyuli.my.shop.domain.User;
import com.xianyuli.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: myShop
 * @Package: com.xianyuli.myShop.view.controller
 * @ClassName: LoginController
 * @Description: 登录入口
 * @Author: LW
 * @CreateDate: 2018/9/25 0025 22:25
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/25 0025 22:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {

        User user = userService.login(email, password);
        if (user != null) {
            request.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
            return "redirect:main";
        }else{

            return "login";
        }

    }


}
