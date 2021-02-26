package com.syg.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 靖鸿宣
 * @since 2021/1/16
 */
@RestController
public class cookie {

    @GetMapping(value = "/setCookie")
    public Object getMethod(HttpServletRequest request, HttpServletResponse response) {
        response.addCookie(new Cookie("name","jhx"));
        response.addCookie(new Cookie("name","jhx"));
        response.addCookie(new Cookie("value","123456"));
        new Cookie("name","name").setMaxAge(100);
        return null;
    }
}
