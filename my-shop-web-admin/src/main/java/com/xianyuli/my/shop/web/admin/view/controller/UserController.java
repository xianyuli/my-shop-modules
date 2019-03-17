package com.xianyuli.my.shop.web.admin.view.controller;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }

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
}
