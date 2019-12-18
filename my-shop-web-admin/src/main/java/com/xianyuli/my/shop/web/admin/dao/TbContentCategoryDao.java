package com.xianyuli.my.shop.web.admin.dao;

import com.xianyuli.my.shop.commoms.persistence.BaseDao;
import com.xianyuli.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao extends BaseDao<TbContentCategory> {

    List<TbContentCategory> selectAll();

    List<TbContentCategory> selectByPid(Long pid);

    int updateStatusByPid(TbContentCategory tbContentCategory);
}
