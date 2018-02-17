package com.bootdo.common.security;

import com.bootdo.common.page.AjaxResponse;
import com.bootdo.common.utils.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;
    @Autowired
    private Provider provider;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        AjaxResponse<String> ajaxResponse = new AjaxResponse<>();
        ajaxResponse.setErrorCode("401");
        ajaxResponse.setSuccess(false);
        ajaxResponse.setMsg("权限不足，无法访问！");
        response.getWriter().println(provider.getObjectMapper().writeValueAsString(ajaxResponse));
        response.getWriter().flush();
    }
}