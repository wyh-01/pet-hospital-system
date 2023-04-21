package com.phs.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 登录拦截器
 * @author wyh
 **/
public class LoginInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String uri = request.getRequestURI();

        //判断当前请求地址是否登录或注册地址
        if(uri.contains("login") || uri.contains("signup"))
        {
            //登录请求，直接放行
            return true;
        }
        else
        {
            //判断用户是否登录
            if(request.getSession().getAttribute("userName")!=null)
            {
                //说明已经登录，放行
                ArrayList<String> urlList = new ArrayList<>();
                List list = Arrays.asList("manegeSystem", "Manage", "add", "update", "add", "delete", "update");
                urlList.addAll(list);
                for(String url : urlList){
                    boolean a = uri.contains(url);
                    Integer i = Integer.parseInt(request.getSession().getAttribute("role").toString());
                    boolean b = i.equals(2);
                    if(uri.contains(url) && request.getSession().getAttribute("role").equals(2)){
                        response.sendRedirect(request.getContextPath() + "/index");
                        return false;
                    }
                }
                return true;
            }
            else
            {
                //没有登录，重定向到登录界面
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }

        //默认拦截
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) throws Exception {
    }
}