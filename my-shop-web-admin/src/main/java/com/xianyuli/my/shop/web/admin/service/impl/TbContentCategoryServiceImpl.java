package com.xianyuli.my.shop.web.admin.service.impl;

import com.xianyuli.my.shop.domain.TbContentCategory;
import com.xianyuli.my.shop.web.admin.dao.TbContentCategoryDao;
import com.xianyuli.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    TbContentCategoryDao tbContentCategoryDao;


    @Override
    public List<TbContentCategory> selectAll() {
        List<TbContentCategory> list = new ArrayList<>();
        List<TbContentCategory> tbContentCategories = tbContentCategoryDao.selectAll();
        //递归排序
        if (tbContentCategories != null && !tbContentCategories.isEmpty()) {
            sortList(tbContentCategories, list, tbContentCategories.get(0));
        }
        return list;
    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }


    private void sortList(List<TbContentCategory> sourceList, List<TbContentCategory> resultList, TbContentCategory parent) {
        resultList.add(parent);
        if (parent.getIsParent()) {
            Long parentId = parent.getId();
            List<TbContentCategory> collect = sourceList.stream().filter(c -> c.getParentId().equals(parentId)).collect(Collectors.toList());
            for (TbContentCategory tbContentCategory : collect) {
                sortList(sourceList, resultList, tbContentCategory);
            }
        }
    }
}
