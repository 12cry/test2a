package com.cry.forum.common;

import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tk.mybatis.mapper.util.StringUtil;
import util.Jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (!StringUtil.isEmpty(authorization)) {
            String token = authorization.substring(7);
            Claims claims = Jwt.parseJWT(token);
            String openid = claims.getSubject();
            request.setAttribute("openid", openid);
        }
        return super.preHandle(request, response, handler);
    }


}
