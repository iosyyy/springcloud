package com.syg.demo.web;

import com.syg.demo.po.MyTb;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author 靖鸿宣
 * @since 2021/1/17
 */
@WebFilter("/*")
@Component
public class Filters implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, @NotNull FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        MyTb mytb=new MyTb();
        Object nt = Proxy.newProxyInstance(mytb.getClass().getClassLoader(), mytb.getClass().getInterfaces()
                , (proxy, method, args) -> {
                    String word = (String) method.invoke(proxy, args);
                    String replace = word.replace("nt", "*");
                    return replace;
        });
        System.out.println(nt);
    }
}

