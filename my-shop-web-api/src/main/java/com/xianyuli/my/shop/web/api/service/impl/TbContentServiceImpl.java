package com.xianyuli.my.shop.web.api.service.impl;

import com.xianyuli.my.shop.domain.TbContent;
import com.xianyuli.my.shop.web.api.dao.TbContentDao;
import com.xianyuli.my.shop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: TbContentServiceImpl
 * @Description: java类作用描述
 * @Author: LW
 */
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    TbContentDao tbContentDao;

    @Override
    public List<TbContent> findByCategoryId(Long id) {
        return tbContentDao.findByCategoryId(id);
    }
}
