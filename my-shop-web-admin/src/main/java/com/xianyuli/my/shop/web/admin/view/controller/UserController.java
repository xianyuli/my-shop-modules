package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ProjectName: my-shop-modules
 * @Package: com.xianyuli.my.shop.web.admin.view.controller
 * @ClassName: UserController
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/10/28 0028 23:28
 * @UpdateUser: LW
 * @UpdateDate: 2018/10/28 0028 23:28
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller

@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }
}
