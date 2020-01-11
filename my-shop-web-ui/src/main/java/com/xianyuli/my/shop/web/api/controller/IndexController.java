package com.xianyuli.my.shop.web.api.controller;

import com.xianyuli.my.shop.web.api.api.ContentApi;
import com.xianyuli.my.shop.web.api.constant.API;
import com.xianyuli.my.shop.web.api.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName: IndexController
 * @Description: 首页
 * @Author: LW
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        List<TbContent> ppts = ContentApi.ppt(API.Constant.PPT_PID);
        model.addAttribute("ppts", ppts);
        return "index";
    }

}
