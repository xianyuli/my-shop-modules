package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.domain.TbContentCategory;
import com.xianyuli.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName: ContentCategoryController
 * @Description: java类作用描述
 * @Author: LW
 */
@Controller
@RequestMapping(value = "content")
public class ContentCategoryController {

    @Autowired
    TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "category/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> tbContentCategories = tbContentCategoryService.selectAll();
        model.addAttribute("tbContentCategories", tbContentCategories);
        return "content_category_list";
    }

}
