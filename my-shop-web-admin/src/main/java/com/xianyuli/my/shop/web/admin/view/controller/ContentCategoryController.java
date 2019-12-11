package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.domain.TbContentCategory;
import com.xianyuli.my.shop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: ContentCategoryController
 * @Description: java类作用描述
 * @Author: LW
 */
@Controller
@RequestMapping(value = "category")
public class ContentCategoryController {

    @Autowired
    TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> list = tbContentCategoryService.selectAll();
        model.addAttribute("tbContentCategories", list);
        return "content_category_list";
    }

    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.GET)
    public List<TbContentCategory> treeData(@RequestParam(value = "id",required = false) Long pid) {
        if (pid==null) {
            pid = 0L;
        }
        return tbContentCategoryService.selectByPid(pid);
    }


}
