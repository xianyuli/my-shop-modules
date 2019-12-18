package com.xianyuli.my.shop.web.admin.service.impl;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.commoms.validator.BeanValidator;
import com.xianyuli.my.shop.domain.TbContentCategory;
import com.xianyuli.my.shop.web.admin.dao.TbContentCategoryDao;
import com.xianyuli.my.shop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        if (tbContentCategories != null && !tbContentCategories.isEmpty()) {
            //查询根节点
            List<TbContentCategory> rootList = tbContentCategoryDao.selectByPid(0L);
            //递归排序
            for (TbContentCategory root : rootList) {
                sortList(tbContentCategories, list, root);
            }
        }

        return list;
    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }

    @Override
    public void updateStatusByPid(TbContentCategory tbContentCategory) {
        //状态设为无效
        tbContentCategory.setStatus(0);
        tbContentCategory.setUpdated(new Date());
        tbContentCategoryDao.updateStatusByPid(tbContentCategory);
    }


    private void sortList(List<TbContentCategory> sourceList, List<TbContentCategory> resultList, TbContentCategory parent) {
        resultList.add(parent);
        if (parent.getIsParent()) {
            Long parentId = parent.getId();
            List<TbContentCategory> collect = sourceList.stream().filter(c -> c.getParent().getId().equals(parentId)).collect(Collectors.toList());
            for (TbContentCategory tbContentCategory : collect) {
                sortList(sourceList, resultList, tbContentCategory);
            }
        }
    }

    @Override
    public PageInfo<TbContentCategory> page(int start, int length, int draw, TbContentCategory tbContentCategory) {
        return null;
    }

    @Override
    public int count(TbContentCategory tbContentCategory) {
        return 0;
    }

    @Override
    public BaseResult save(TbContentCategory tbContentCategory) {
        String validMsg = BeanValidator.validator(tbContentCategory);
        if (StringUtils.isNotBlank(validMsg)) {
            return BaseResult.fail(validMsg);
        } else {
            TbContentCategory parent = tbContentCategory.getParent();
            // 如果没有选择父级节点则默认设置为根目录
            if (parent == null || parent.getId() == null) {
                // 0 代表根目录
                parent = new TbContentCategory();
                parent.setId(0L);
                tbContentCategory.setParent(parent);
            }
            Date date = new Date();
            tbContentCategory.setUpdated(date);
            tbContentCategory.setStatus(1);
            if (tbContentCategory.getId() == null) {
                parent = tbContentCategoryDao.getById(parent.getId());
                if (parent == null || parent.getParent().getId() == 0) {
                    tbContentCategory.setIsParent(true);
                } else {
                    tbContentCategory.setIsParent(false);
                }
                tbContentCategory.setCreated(date);
                tbContentCategoryDao.insert(tbContentCategory);
            } else {
                tbContentCategoryDao.update(tbContentCategory);
            }
            return BaseResult.success("保存成功");
        }
    }

    @Override
    public void delete(long id) {
        tbContentCategoryDao.delete(id);
    }

    @Override
    public TbContentCategory getById(long id) {
        return tbContentCategoryDao.getById(id);
    }

    @Override
    public void update(TbContentCategory tbContentCategory) {

    }

    @Override
    public int deleteMutil(String[] ids) {
        return 0;
    }
}
