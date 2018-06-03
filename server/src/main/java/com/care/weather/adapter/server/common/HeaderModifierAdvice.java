package com.care.weather.adapter.server.common;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class HeaderModifierAdvice implements ResponseBodyAdvice<Object> {

    private static final String ACCESS_CONTROL_ALLOW_ORIGIN_VALUE = "*";
    private static final String ACCESS_CONTROL_ALLOW_METHODS_VALUE = "GET";

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, ACCESS_CONTROL_ALLOW_ORIGIN_VALUE);
        response.getHeaders().add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, ACCESS_CONTROL_ALLOW_METHODS_VALUE);
        return body;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
}