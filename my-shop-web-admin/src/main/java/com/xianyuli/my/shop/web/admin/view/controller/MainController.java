package com.xianyuli.my.shop.web.admin.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: myShop
 * @Package: com.xianyuli.myShop.view.controller
 * @ClassName: MainController
 * @Description: 跳转首页
 * @Author: LW
 * @CreateDate: 2018/9/26 0026 23:05
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/26 0026 23:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class MainController {

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String toMain() {
        return "main";
    }
}
