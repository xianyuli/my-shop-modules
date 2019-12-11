package com.xianyuli.my.shop.web.admin.service;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.domain.TbContent;
import com.xianyuli.my.shop.domain.TbUser;

/**
 * @ClassName: TbContentService
 * @Description: java类作用描述
 * @Author: LW
 */
public interface TbContentService {

    PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent);

    int count(TbContent tbContent);

    BaseResult save(TbContent tbContent);

    void delete(long id);

    TbContent getById(long id);

    void update(TbContent tbContent);

    int deleteMutil(String[] ids);

}
