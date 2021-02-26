package com.syg.demo.web;

import com.syg.demo.dao.MyTbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 靖鸿宣
 * @since 2021/1/4
 */

@RestController
public class DowlondFile {
    @Autowired
    MyTbMapper mapper;

    @GetMapping(value = "/downlodFile")
    public Object get(@RequestParam(defaultValue = "without file")String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("name", "value");

        response.addCookie(cookie);
        if("null".equals(filename))
        {
            return filename;
        }
        InputStream fileInputStream = DowlondFile.class.getClassLoader().getResourceAsStream(filename);
        if(fileInputStream==null)
        {
            return "无法找到文件";
        }
        response.setContentType(request.getServletContext().getMimeType(filename));
        response.setHeader("content-disposition","attachment;filename="+filename);
        int len;
        byte[] bytes=new byte[1024];
        ServletOutputStream outputStream = response.getOutputStream();
        while ((len=fileInputStream.read(bytes))!=-1)
        {
            outputStream.write(bytes,0,len);
        }
        return null;
    }

}
