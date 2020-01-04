package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.domain.TbContent;
import com.xianyuli.my.shop.web.admin.abstracts.AbstractBaseController;
import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

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
public class UserController extends AbstractBaseController<TbUser, TbUserService> {

    @Override
    @ModelAttribute
    public TbUser setEntity(Long id) {
        TbUser tbUser = null;
        if (id != null) {
            tbUser = service.getById(id);
        } else {
            tbUser = new TbUser();
        }
        return tbUser;
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
    public String form(TbUser tbUser) {
        return "user_form";
    }


    /**
     * 功能描述: 跳转用户列表
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/10/29 0029 23:18
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
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
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbUser);
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        } else {
            model.addAttribute("baseResult", baseResult);
            model.addAttribute("tbUser", tbUser);
            return form(tbUser);
        }
    }

    /**
     * 功能描述: 删除用户<br>
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
        TbUser tbUser = service.getById(id);
        model.addAttribute("tbUser", tbUser);
        return "user_detail";
    }
}
