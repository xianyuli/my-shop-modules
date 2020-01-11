package com.xianyuli.my.shop.web.api.controller;

import com.google.code.kaptcha.Constants;
import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.web.api.api.UserApi;
import com.xianyuli.my.shop.web.api.dto.TbUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value = "login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(TbUser user, HttpServletRequest request, Model model) throws Exception {
        if (!checkVerification(user, request)) {
            model.addAttribute("baseresult", BaseResult.fail("验证码错误，请重新输入"));
            return "login";
        }
        TbUser login = UserApi.login(user);
        if (login != null) {
            request.getSession().setAttribute("tbuser", user);
            return "redirect:index";
        } else {
            model.addAttribute("baseresult", BaseResult.fail("账号或者密码错误"));
            return "login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

    private boolean checkVerification(TbUser user, HttpServletRequest request) {
        String kaptcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.equals(kaptcha,user.getVerification())) {
            return true;
        }
        return false;

    }
}
