package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.domain.TbContent;
import com.xianyuli.my.shop.domain.TbContentCategory;
import com.xianyuli.my.shop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    @ModelAttribute
    public TbContentCategory setTbContent(Long id) {
        TbContentCategory tbContentCategory = null;
        if (id != null) {
            tbContentCategory = tbContentCategoryService.getById(id);
        } else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }

    /**
     * 列表查询
     * @param model
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> list = tbContentCategoryService.selectAll();
        model.addAttribute("tbContentCategories", list);
        return "content_category_list";
    }

    /**
     * 树形表单
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.GET)
    public List<TbContentCategory> treeData(@RequestParam(value = "id",required = false) Long pid) {
        if (pid==null) {
            pid = 0L;
        }
        return tbContentCategoryService.selectByPid(pid);
    }

    /**
     * 跳转表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(TbContentCategory tbContentCategory) {
        return "content_category_form";
    }

    /**
     * 功能描述: 提交信息
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/10/30 0030 0:06
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbContentCategoryService.save(tbContentCategory);
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/category/list";
        } else {
            model.addAttribute("baseResult", baseResult);
            model.addAttribute("tbContentCategory", tbContentCategory);
            return form(tbContentCategory);
        }
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            TbContentCategory parent = tbContentCategoryService.getById(Long.parseLong(ids));
            tbContentCategoryService.delete(Long.parseLong(ids));
            tbContentCategoryService.updateStatusByPid(parent);
            baseResult = BaseResult.success("删除分类及其子类及其全部内容成功");
        } else {
            baseResult = BaseResult.fail("删除分类失败");
        }

        return baseResult;
    }

}
