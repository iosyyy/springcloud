package com.syg.demo.dao;

import com.syg.demo.po.MyTb;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyTbMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(MyTb record);

    int insertSelective(MyTb record);

    MyTb selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(MyTb record);

    int updateByPrimaryKey(MyTb record);
}