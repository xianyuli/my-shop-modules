package com.xianyuli.my.shop.web.admin.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: myShop
 * @Package: com.xianyuli.myShop.view.controller
 * @ClassName: LogoutController
 * @Description: 注销控制器
 * @Author: LW
 * @CreateDate: 2018/9/26 0026 23:28
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/26 0026 23:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class LogoutController {

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }
}
