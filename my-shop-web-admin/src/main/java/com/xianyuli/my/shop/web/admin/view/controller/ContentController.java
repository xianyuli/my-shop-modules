package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.domain.TbContent;
import com.xianyuli.my.shop.web.admin.abstracts.AbstractBaseController;
import com.xianyuli.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ContentController
 * @Description: java类作用描述
 * @Author: LW
 */
@Controller
@RequestMapping(value = "content")
public class ContentController extends AbstractBaseController<TbContent, TbContentService> {


    @Override
    @ModelAttribute
    public TbContent setEntity(Long id) {
        TbContent tbContent = null;
        if (id != null) {
            tbContent = service.getById(id);
        } else {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    /**
     * 功能描述: 跳转用户表单
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/10/29 0029 23:18
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(TbContent tbContent) {
        return "content_form";
    }



    /**
     * 功能描述: 跳转列表
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/10/29 0029 23:18
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        return "content_list";
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
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbContent);
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        } else {
            model.addAttribute("baseResult", baseResult);
            model.addAttribute("tbContent", tbContent);
            return form(tbContent);
        }
    }

    /**
     * 功能描述: 删除<br>
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2019/6/23 0023 15:54
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(@RequestParam("ids[]") String[] ids) {
        int i = service.deleteMutil(ids);
        return BaseResult.success();
    }


    @Override
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(long id, Model model) {
        TbContent tbContent = service.getById(id);
        model.addAttribute("tbContent", tbContent);
        return "content_detail";
    }
}
