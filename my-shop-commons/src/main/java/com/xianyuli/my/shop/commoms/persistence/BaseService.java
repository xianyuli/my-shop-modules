package com.xianyuli.my.shop.commoms.persistence;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;

/**
 * @ClassName: BaseService
 * @Description: java类作用描述
 * @Author: LW
 */
public interface BaseService<T extends BaseEntity> {
    PageInfo<T> page(int start, int length, int draw, T t);

    int count(T t);

    BaseResult save(T t);

    void delete(long id);

    T getById(long id);

    void update(T t);

    int deleteMutil(String[] ids);
}
