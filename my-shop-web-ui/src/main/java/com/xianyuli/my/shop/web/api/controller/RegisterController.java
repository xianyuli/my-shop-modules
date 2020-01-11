package com.xianyuli.my.shop.web.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: RegisterController
 * @Description: 注册
 * @Author: LW
 */
@Controller
public class RegisterController {

    @RequestMapping(value = "register")
    public String toRegister() {
        return "register";
    }

}
