package com.phc.das.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class CustomLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    public CustomLoginUrlAuthenticationEntryPoint(String LOGIN_URL) {
        super(LOGIN_URL);
    }

    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException exception) {

        String redirect = super.determineUrlToUseForThisRequest(request, response, exception);
        // formed string: "/signUp?param1=val1,param2=val2 etc.
        return redirect;
    }

}
