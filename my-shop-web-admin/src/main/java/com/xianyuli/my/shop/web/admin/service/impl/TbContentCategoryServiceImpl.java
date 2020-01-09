package com.xianyuli.my.shop.web.admin.service.impl;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.validator.BeanValidator;
import com.xianyuli.my.shop.domain.TbContentCategory;
import com.xianyuli.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.xianyuli.my.shop.web.admin.dao.TbContentCategoryDao;
import com.xianyuli.my.shop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LW
 */
@Service
public class TbContentCategoryServiceImpl extends AbstractBaseServiceImpl<TbContentCategory, TbContentCategoryDao> implements TbContentCategoryService {

    @Override
    public List<TbContentCategory> selectAll() {
        List<TbContentCategory> list = new ArrayList<>();
        List<TbContentCategory> tbContentCategories = dao.selectAll();
        if (tbContentCategories != null && !tbContentCategories.isEmpty()) {
            //查询根节点 根节点的parentId=0
            List<TbContentCategory> rootList = dao.selectByPid(0L);
            //递归排序
            for (TbContentCategory root : rootList) {
                sortList(tbContentCategories, list, root);
            }
        }
        return list;
    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return dao.selectByPid(pid);
    }

    @Override
    public void updateStatusByPid(TbContentCategory tbContentCategory) {
        //状态设为无效
        tbContentCategory.setStatus(0);
        tbContentCategory.setUpdated(new Date());
        dao.updateStatusByPid(tbContentCategory);
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
    @Transactional
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
                tbContentCategory.setIsParent(false);
                // 判断当前新增的节点有没有父级节点
                if (parent.getId() != 0L) {
                    parent = dao.getById(parent.getId());
                    if (parent != null) {
                        parent.setIsParent(true);
                        update(parent);
                    }
                }
                tbContentCategory.setCreated(date);
                dao.insert(tbContentCategory);
            } else {
                update(tbContentCategory);
            }
            return BaseResult.success("保存成功");
        }
    }
}
