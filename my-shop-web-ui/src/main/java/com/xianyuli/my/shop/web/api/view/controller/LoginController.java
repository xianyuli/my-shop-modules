package com.xianyuli.my.shop.web.api.view.controller;

import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.api.api.UserApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName: LoginController
 * @Description: 登录
 * @Author: LW
 */
@Controller
public class LoginController {

    @RequestMapping(value = "login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(TbUser user) {
        TbUser login = UserApi.login(user);
        if (login!=null) {
            return "redirect:index";
        }
        return "login";
    }
}
