package com.tensquare.qa.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
            System.out.println("经过了拦截器");

        String header = request.getHeader("Authorization");
        if(header !=null && !"".equals(header)){
            if(header.startsWith("Bearer ")){
                String tocken = header.substring(7);
                try {
                    Claims claims = this.jwtUtil.parseJWT(tocken);
                    String roles = (String) claims.get("roles");
                    if(roles != null && roles.equals("admin")){
                        request.setAttribute("claims_admin",tocken);
                    }
                    if(roles != null && roles.equals("user")){
                        request.setAttribute("claims_user",tocken);
                    }
                }catch (Exception e){
                    throw new RuntimeException("令牌不正确!");
                }
            }
        }

        return true;
    }


}
