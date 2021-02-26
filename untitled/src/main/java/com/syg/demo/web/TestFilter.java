package com.syg.demo.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 靖鸿宣
 * @since 2021/1/17
 */
@WebFilter("/*")
@Configuration
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(@RequestBody ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1= (HttpServletRequest) request;
        HttpServletResponse response1= (HttpServletResponse) response;
        String requestURI = request1.getRequestURI();

        if(requestURI.contains("/login")||requestURI.contains(".css")||requestURI.contains("img"))
        {
            chain.doFilter(request1,response);
        }else{
            Object userHasLogin = request1.getSession().getAttribute("userHasLogin");
            if(userHasLogin!=null)
            {
                chain.doFilter(request1,response);
            }else {
                response1.sendRedirect("/loginFail");
            }
        }
    }
}
