package com.lgcns.inspire_restjpa.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        System.out.println("[debug] >>> JwtFilter doFilter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();
        System.out.println("[debug] >>> client path /" + path);
        String method = req.getMethod();
        System.out.println("[debug] >>> client method :" + method);
        
        if(isPath(path)){
            chain.doFilter(request, response);
            return ;
        }
    }

    // 특정 endpoint에 대해서는 인가없이 컨트롤러 이동이 가능하도록

    public boolean isPath(String path){
        return path.startsWith("/swagger-ui") ||
               path.startsWith("/v3/api-docs")||
               path.startsWith("/api/v2/inspire/user/signup")||
               path.startsWith("/api/v2/inspire/user/signin");
    }
}
