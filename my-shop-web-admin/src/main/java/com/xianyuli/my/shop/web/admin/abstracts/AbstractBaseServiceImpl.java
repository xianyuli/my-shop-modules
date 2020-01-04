package com.xianyuli.my.shop.web.admin.abstracts;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.commoms.persistence.BaseDao;
import com.xianyuli.my.shop.commoms.persistence.BaseEntity;
import com.xianyuli.my.shop.commoms.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName: AbstractBaseServiceImpl
 * @Description: java类作用描述
 * @Author: LW
 */
public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    protected D dao;

    @Override
    public PageInfo<T> page(int start, int length, int draw, T t) {
        PageInfo<T> result = new PageInfo<>();
        List<T> list = dao.page(start, length, t);
        int count = count(t);
        result.setDraw(draw);
        result.setRecordsTotal(count);
        result.setRecordsFiltered(count);
        result.setData(list);
        result.setError("");
        return result;
    }

    @Override
    public int count(T t) {
        return dao.count(t);
    }

    @Override
    public abstract BaseResult save(T t);

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public T getById(long id) {
        return dao.getById(id);
    }

    @Override
    public void update(T t) {
        dao.update(t);
    }

    @Override
    public int deleteMutil(String[] ids) {
        return dao.deleteMutil(ids);
    }
}
