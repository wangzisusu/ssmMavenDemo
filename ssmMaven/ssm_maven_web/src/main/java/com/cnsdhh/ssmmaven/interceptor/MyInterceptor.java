package com.cnsdhh.ssmmaven.interceptor;

import com.cnsdhh.ssmmaven.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyInterceptor implements HandlerInterceptor {

    // 在目标方法执行之前 执行
    // 返回值：true为放行，false为终止
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        //System.out.println("1 -> 在目标方法执行之前：" + loginUser);
        // 判断用户是否登录，若未登录则拦截后面的访问请求，并跳转到登录页面
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/static/user/login.html");
            return false;  // 终止
        } else {
            return true;   // 放行
        }
    }

    // 在目标方法执行之后，在视图对象返回之前 执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //System.out.println("1 -> 在目标方法执行之后，在视图对象返回之前 执行 ...");
    }

    // 在流程都执行完毕后 执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //System.out.println("1 -> 在流程都执行完毕后 执行 ...");
    }

}
