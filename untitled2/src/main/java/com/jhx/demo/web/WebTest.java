package com.jhx.demo.web;

import com.jhx.demo.dao.MyTbMapper;
import com.jhx.demo.po.MyTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 靖鸿宣
 * @since 2021/2/14
 */
@RestController
public class WebTest {
    @Autowired
    MyTbMapper mapper;
    
    @GetMapping("/name")
    public List<MyTb> myTb()
    {
        
        return mapper.selectByPrimaryKey(110);
    }
    
}
