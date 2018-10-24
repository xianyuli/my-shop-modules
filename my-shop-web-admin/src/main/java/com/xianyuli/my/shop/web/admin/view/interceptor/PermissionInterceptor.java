package com.xianyuli.my.shop.web.admin.view.interceptor;

import com.xianyuli.my.shop.commoms.utils.ConstantUtils;
import com.xianyuli.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: myShop
 * @Package: com.xianyuli.myShop.view.interceptor
 * @ClassName: PermissionInterceptor
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/9/26 0026 23:18
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/26 0026 23:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView.getViewName().endsWith("login")) {
            TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (tbUser != null) {
                httpServletResponse.sendRedirect("/main");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
