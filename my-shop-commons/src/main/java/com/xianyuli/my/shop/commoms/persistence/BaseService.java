package com.xianyuli.my.shop.commoms.persistence;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;

/**
 * 功能描述: 业务interface基类<br>
 * 〈〉
 *
 * @return:
 * @Author:LW
 * @Date: 2020/01/12 1:24
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
