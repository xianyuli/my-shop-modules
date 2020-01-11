package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.utils.ConstantUtils;
import com.xianyuli.my.shop.commoms.utils.CookieUtils;
import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private TbUserService tbUserService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password,
                        HttpServletRequest request, HttpServletResponse response, Model model) {
        String isRemember = request.getParameter("isRemember");
        if ("on".equals(isRemember)) {
            CookieUtils.setCookie(request, response, "rememberName", email, 60 * 60 * 24 * 7, true);
            request.setAttribute("isRemember", "on");
        } else{
            CookieUtils.deleteCookie(request, response, "rememberName");
        }
        if (StringUtils.isEmpty(email)) {
            return null;
        }
        TbUser tbUser = tbUserService.login(email, password);
        if (tbUser != null) {
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:/main";
        } else {
            model.addAttribute("message", "用户名或者密码错误，请重新输入！");
            return "login";
        }

    }


}
