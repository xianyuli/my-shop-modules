package com.xianyuli.my.shop.web.api.dao;

import com.xianyuli.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: TbContentMapper
 * @Description: java类作用描述
 * @Author: LW
 */
@Repository
public interface TbContentDao {
    List<TbContent> findByCategoryId(long categoryId);
}