package com.csc340.study_grouper.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

import java.io.IOException;
public class CustomAuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        String redirectURL = request.getContextPath();

        if (authentication.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("admin"))) {
            redirectURL = "/admin-view/admin-home";
        } else if (authentication.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("student"))){
            redirectURL = "/home";
        } else if (authentication.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("instructor"))){
            redirectURL = "/home"; }

        response.sendRedirect(redirectURL);
    }
}
