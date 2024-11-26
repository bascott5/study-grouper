package com.csc340.study_grouper.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        String redirectUrl = request.getContextPath();

        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("admin"))){
            redirectUrl = "/admin/home";
        } else if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("instructor"))){
            redirectUrl = "/instructor/home";
        }
        else if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("student"))){
            redirectUrl = "/student/home";
        }
        response.sendRedirect(redirectUrl);
    }
}
