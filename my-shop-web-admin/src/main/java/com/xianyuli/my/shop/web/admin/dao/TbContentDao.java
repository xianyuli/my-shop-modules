package com.xianyuli.my.shop.web.admin.dao;

import com.xianyuli.my.shop.commoms.persistence.BaseDao;
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
public interface TbContentDao extends BaseDao<TbContent> {

    int insertSelective(TbContent record);


    int updateByIdSelective(TbContent record);
}