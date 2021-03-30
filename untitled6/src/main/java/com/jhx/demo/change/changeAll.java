package com.jhx.demo.change;

import com.jhx.demo.dao.LitemallCategoryMapper;
import com.jhx.demo.dao.LitemallGoodsMapper;
import com.jhx.demo.dao.LitemallStorageMapper;
import com.jhx.demo.po.LitemallCategory;
import com.jhx.demo.po.LitemallGoods;
import com.jhx.demo.po.LitemallStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author 靖鸿宣
 * @since 2021/3/29
 */
@Configuration
public class changeAll {
    @Autowired
    LitemallStorageMapper mapper;

    @Autowired
    LitemallGoodsMapper litemallGoodsMapper;

    @Autowired
    LitemallCategoryMapper litemallCategoryMapper;

    @Bean
    public void selectAll(){
        List<LitemallStorage> litemallStorages = mapper.selectAll();
        for (LitemallStorage litemallStorage : litemallStorages) {
            LitemallStorage litemallStorage1 = new LitemallStorage();
            String key = litemallStorage.getKey();
            litemallStorage1.setUrl("https://wxapp.simplesay.top/wx/storage/fetch/"+key);
            litemallStorage1.setId(litemallStorage.getId());
            mapper.updateUrl(litemallStorage1);
        }

    }

    @Bean
    public void ChangeGoods(){
        List<LitemallGoods> litemallGoods = litemallGoodsMapper.selectAll();
        for (LitemallGoods litemallGood : litemallGoods) {
            String gallery = litemallGood.getGallery();
            if (gallery!=null){
                litemallGood.setGallery(gallery.replace("http://localhost:8080/wx/storage/fetch/", "https://wxapp.simplesay.top/wx/storage/fetch/"));
            }
            litemallGoodsMapper.updateByPrimaryKeySelective(litemallGood);
        }

    }


    @Bean
    public void changeCategory(){
        List<LitemallCategory> litemallCategories = litemallCategoryMapper.selectAll();
        for (LitemallCategory litemallCategory : litemallCategories) {
            String picUrl = litemallCategory.getPicUrl();
            String iconUrl = litemallCategory.getIconUrl();
            System.out.println(litemallCategory);
            if(picUrl!=null){
                litemallCategory.setPicUrl(picUrl.replace("http://localhost:8080/wx/storage/fetch/", "https://wxapp.simplesay.top/wx/storage/fetch/"));
            }
            if(iconUrl!=null){
                litemallCategory.setIconUrl(iconUrl.replace("http://localhost:8080/wx/storage/fetch/", "https://wxapp.simplesay.top/wx/storage/fetch/"));
            }
            litemallCategoryMapper.updateDetail(litemallCategory);
        }
    }

}
