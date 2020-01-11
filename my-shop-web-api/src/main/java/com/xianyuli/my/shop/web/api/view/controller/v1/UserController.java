package com.xianyuli.my.shop.web.api.view.controller.v1;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.api.dto.TbUserDTO;
import com.xianyuli.my.shop.web.api.service.TbUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users/v1")
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @PostMapping("login")
    public BaseResult login(TbUser user) {
        TbUser loginUser = tbUserService.login(user);
        if (loginUser == null) {
            return BaseResult.fail("账号或密码错误");
        }
        TbUserDTO tbUserDTO = new TbUserDTO();
        BeanUtils.copyProperties(loginUser,tbUserDTO);
        return BaseResult.success("登录成功", tbUserDTO);
    }

}
