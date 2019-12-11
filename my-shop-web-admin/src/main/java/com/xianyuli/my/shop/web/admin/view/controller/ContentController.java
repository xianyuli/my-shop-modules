package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.domain.TbContent;
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
public class ContentController {
    /**
     * 功能描述: 跳转用户表单
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/10/29 0029 23:18
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content_form";
    }

    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent setTbContent(Long id) {
        TbContent tbContent = null;
        if (id != null) {
            tbContent = tbContentService.getById(id);
        } else {
            tbContent = new TbContent();
        }
        return tbContent;
    }


    /**
     * 功能描述: 跳转列表
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/10/29 0029 23:18
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
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
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbContentService.save(tbContent);
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        } else {
            model.addAttribute("baseResult", baseResult);
            model.addAttribute("tbContent", tbContent);
            return "content_form";
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
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult detele(@RequestParam("ids[]") String[] ids) {
        int i = tbContentService.deleteMutil(ids);
        return BaseResult.success();
    }

    /**
     * 分页查询
     *
     * @param request
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent) {
        String strDraw = request.getParameter("draw");
        String strLength = request.getParameter("length");
        String strStart = request.getParameter("start");
        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int length = strLength == null ? 0 : Integer.parseInt(strLength);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        return tbContentService.page(start, length, draw, tbContent);
    }


    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(long id, Model model) {
        TbContent tbContent = tbContentService.getById(id);
        model.addAttribute("tbContent", tbContent);
        return "content_detail";
    }
}
