package com.xianyuli.my.shop.commoms.persistence;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: BaseDao
 * @Description: 数据访问层的基类
 * @Author: LW
 */
public interface BaseDao<T extends BaseEntity> {
    /**
     * 新增
     *
     * @param t
     */
    void insert(T t);

    /**
     * 删除
     *
     * @param id
     */
    int delete(long id);

    /**
     * 根据ID获取用户
     *
     * @param id
     * @return
     */
    T getById(long id);

    /**
     * 更新
     *
     * @param t
     */
    void update(T t);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteMutil(String[] ids);

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @return
     */
    List<T> page(@Param("start") int start, @Param("length") int length, T t);

    /**
     * 分页查询的统计
     *
     * @return
     */
    Integer count(T t);


}
