package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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
        return "user_form";
    }

    @Autowired
    private TbUserService tbUserService;

    @ModelAttribute
    public TbUser setTbuser(Long id) {
        TbUser tbUser = null;
        if (id != null) {
            tbUser = tbUserService.getById(id);
        } else {
            tbUser = new TbUser();
        }
        return tbUser;
    }


    /**
     * 功能描述: 跳转用户列表
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/10/29 0029 23:18
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user_list";
    }

    /**
     * 功能描述: 提交用户信息
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/10/30 0030 0:06
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbUserService.save(tbUser);
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        } else {
            model.addAttribute("baseResult", baseResult);
            model.addAttribute("tbUser", tbUser);
            return "user_form";
        }
    }

    /**
     * 功能描述: 搜索用户<br>
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2019/6/3 0003 22:37
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(TbUser tbUser, Model model) {
        List<TbUser> tbUsers = tbUserService.search(tbUser);
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }

    /**
     * 功能描述: 删除用户<br>
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2019/6/23 0023 15:54
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult detele(@RequestParam("ids[]") String[] ids) {
        int i = tbUserService.deleteMutil(ids);
        return BaseResult.success();
    }

    /**
     * 分页查询
     *
     * @param request
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request, TbUser tbUser) {
        String strDraw = request.getParameter("draw");
        String strLength = request.getParameter("length");
        String strStart = request.getParameter("start");
        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int length = strLength == null ? 0 : Integer.parseInt(strLength);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        return tbUserService.page(start, length, draw, tbUser);
    }


    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(long id, Model model) {
        TbUser tbUser = tbUserService.getById(id);
        model.addAttribute("tbUser", tbUser);
        return "user_detail";
    }
}
