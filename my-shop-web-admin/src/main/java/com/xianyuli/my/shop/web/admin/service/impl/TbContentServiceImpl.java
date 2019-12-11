package com.xianyuli.my.shop.web.admin.service.impl;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.dto.PageInfo;
import com.xianyuli.my.shop.commoms.utils.ConstantUtils;
import com.xianyuli.my.shop.domain.TbContent;
import com.xianyuli.my.shop.web.admin.dao.TbContentDao;
import com.xianyuli.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent) {
        PageInfo<TbContent> result = new PageInfo<>();
        List<TbContent> list = tbContentDao.page(start, length, tbContent);
        int count = count(tbContent);
        result.setDraw(draw);
        result.setRecordsTotal(count);
        result.setRecordsFiltered(count);
        result.setData(list);
        result.setError("");
        return result;
    }

    @Override
    public int count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        BaseResult baseResult = checkContent(tbContent);
        if (baseResult.getStatus() == ConstantUtils.STATUS_SUCCESS) {
            tbContent.setUpdated(new Date());
            //新增内容
            if (tbContent.getId() == null) {
                //密码加密
                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
            } else {//更新用户
                tbContentDao.updateByIdSelective(tbContent);
            }
            baseResult.setMsg("保存成功");
        }

        return baseResult;

    }

    private BaseResult checkContent(TbContent tbContent) {
        return BaseResult.success();
    }

    @Override
    public void delete(long id) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent getById(long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void update(TbContent tbContent) {
        tbContentDao.updateByIdSelective(tbContent);
    }

    @Override
    public int deleteMutil(String[] ids) {
        return tbContentDao.deleteMutil(ids);
    }

}
