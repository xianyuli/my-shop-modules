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
 * @ClassName: LoginInterceptor
 * @Description: 登录拦截器
 * @Author: LW
 * @CreateDate: 2018/9/26 0026 22:57
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/26 0026 22:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        if (tbUser == null) {
            httpServletResponse.sendRedirect("/login");
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
