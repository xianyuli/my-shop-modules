package com.xianyuli.my.shop.web.api.interceptor;

import com.xianyuli.my.shop.web.api.constant.API;
import com.xianyuli.my.shop.web.api.dto.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 未登录拦截，跳转登录页
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(API.Constant.SESSION_USER);
        String servletPath = httpServletRequest.getServletPath();
        if (tbUser == null && !servletPath.endsWith("register") && !servletPath.endsWith("login")) {
            httpServletResponse.sendRedirect("/login");
            return false;
        } else {
            return true;
        }

    }

    /**
     * 已登录直接跳转主页
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && (modelAndView.getViewName().endsWith("login")||modelAndView.getViewName().endsWith("register"))) {
            TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(API.Constant.SESSION_USER);
            if (tbUser != null) {
                httpServletResponse.sendRedirect("/index");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
