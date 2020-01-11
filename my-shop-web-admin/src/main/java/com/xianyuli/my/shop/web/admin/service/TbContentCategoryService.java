package com.xianyuli.my.shop.web.admin.service;

import com.xianyuli.my.shop.commoms.persistence.BaseService;
import com.xianyuli.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService extends BaseService<TbContentCategory> {

    List<TbContentCategory> selectAll();

    List<TbContentCategory> selectByPid(Long pid);

    void updateStatusByPid(TbContentCategory tbContentCategory);

}
