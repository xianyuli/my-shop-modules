package com.xianyuli.my.shop.web.admin.abstracts;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.commoms.persistence.BaseEntity;
import com.xianyuli.my.shop.commoms.persistence.BaseService;
import com.xianyuli.my.shop.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述: 控制器模板<br>
 * 〈〉
 *
 * @return:
 * @Author:LW
 * @Date: 2020/01/12 1:29
 */
public abstract class AbstractBaseController<T extends BaseEntity, S extends BaseService<T>> {

    @Autowired
    protected S service;

    @ModelAttribute
    public abstract T setEntity(Long id);

    public abstract String form(T t);

    public abstract String list(Model model);

    public abstract String save(T t, Model model, RedirectAttributes redirectAttributes);

    public abstract BaseResult delete(@RequestParam("ids[]") String[] ids);

    /**
     * 分页查询
     * @param request
     * @param t
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<T> page(HttpServletRequest request, T t) {
        String strDraw = request.getParameter("draw");
        String strLength = request.getParameter("length");
        String strStart = request.getParameter("start");
        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int length = strLength == null ? 0 : Integer.parseInt(strLength);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        return service.page(start, length, draw, t);
    }

    public abstract String detail(long id, Model model);

}
