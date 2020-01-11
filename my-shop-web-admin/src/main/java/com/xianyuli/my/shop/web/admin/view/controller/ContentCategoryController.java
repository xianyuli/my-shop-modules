package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.commoms.utils.ConstantUtils;
import com.xianyuli.my.shop.domain.TbContentCategory;
import com.xianyuli.my.shop.web.admin.abstracts.AbstractBaseController;
import com.xianyuli.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "category")
public class ContentCategoryController extends AbstractBaseController<TbContentCategory, TbContentCategoryService> {

    @Override
    @ModelAttribute
    public TbContentCategory setEntity(Long id) {
        TbContentCategory tbContentCategory = null;
        if (id != null) {
            tbContentCategory = service.getById(id);
        } else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }

    /**
     * 列表查询
     *
     * @param model
     * @return
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> list = service.selectAll();
        model.addAttribute("tbContentCategories", list);
        return "content_category_list";
    }

    /**
     * 树形表单
     *
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.GET)
    public List<TbContentCategory> treeData(@RequestParam(value = "id", required = false) Long pid) {
        if (pid == null) {
            pid = 0L;
        }
        return service.selectByPid(pid);
    }

    /**
     * 跳转表单页
     *
     * @return
     */
    @Override
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
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbContentCategory);
        if (baseResult.getStatus() == ConstantUtils.STATUS_SUCCESS) {
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
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(@RequestParam("ids[]") String[] ids) {
        Long id = null;
        if (ids != null && ids.length > 0) {
            id = Long.parseLong(ids[0]);
        }else {
            return BaseResult.fail("删除分类失败");
        }
        BaseResult baseResult = null;
        TbContentCategory parent = service.getById(id);
        service.delete(id);
        service.updateStatusByPid(parent);
        baseResult = BaseResult.success("删除分类及其子类及其全部内容成功");

        return baseResult;
    }

    @Override
    public PageInfo<TbContentCategory> page(HttpServletRequest request, TbContentCategory tbContentCategory) {
        return null;
    }

    @Override
    public String detail(long id, Model model) {
        return null;
    }

}
