package com.syg.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 靖鸿宣
 * @since 2021/1/16
 */
@RestController
public class Cookier {
    @GetMapping("/getCookie")
    public String get(HttpServletRequest request, HttpServletRequest response)
    {
        for (Cookie cookie : request.getCookies()) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }

        return "";
    }

}
