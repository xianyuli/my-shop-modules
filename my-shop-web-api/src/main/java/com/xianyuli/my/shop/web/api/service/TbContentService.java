package com.xianyuli.my.shop.web.api.service;

import com.xianyuli.my.shop.domain.TbContent;

import java.util.List;

/**
 * @ClassName: TbContentService
 * @Description: java类作用描述
 * @Author: LW
 */
public interface TbContentService {
    List<TbContent> findByCategoryId(Long id);
}
