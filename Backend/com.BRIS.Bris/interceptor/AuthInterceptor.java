package com.BRIS.Login.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();


        if (uri.equals("/") || uri.equals("/login")) {
            return true;
        }


        if (uri.startsWith("/Css/") || uri.startsWith("/Js/") || uri.startsWith("/Images/")) {
            return true;
        }


        if (session != null && session.getAttribute("user") != null) {
            return true;
        }


        response.sendRedirect("/");
        return false;
    }
}
