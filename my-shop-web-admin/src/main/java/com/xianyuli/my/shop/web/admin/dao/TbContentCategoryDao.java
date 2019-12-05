package com.xianyuli.my.shop.web.admin.dao;

import com.xianyuli.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao {

    List<TbContentCategory> selectAll();
}
