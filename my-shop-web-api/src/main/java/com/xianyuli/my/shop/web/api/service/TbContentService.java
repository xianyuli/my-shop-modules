package com.xianyuli.my.shop.web.api.service;

import com.xianyuli.my.shop.domain.TbContent;

import java.util.List;

public interface TbContentService {
    List<TbContent> findByCategoryId(Long id);
}
