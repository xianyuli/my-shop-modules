package com.xianyuli.my.shop.web.admin.dao;

import com.xianyuli.my.shop.domain.TbContent;
import com.xianyuli.my.shop.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: TbContentMapper
 * @Description: java类作用描述
 * @Author: LW
 */
@Repository
public interface TbContentDao {
    /**
     * 新增
     *
     * @param content
     * @return
     */
    int insert(TbContent content);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    TbContent getById(Long id);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int update(TbContent record);

    int insertSelective(TbContent record);


    int updateByIdSelective(TbContent record);


    int count(@Param("content") TbContent tbContent);

    List<TbContent> page(@Param("start") int start, @Param("length") int length, @Param("content") TbContent tbContent);

    int deleteMutil(String[] ids);
}