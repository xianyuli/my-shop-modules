package com.xianyuli.my.shop.web.admin.service.impl;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.xianyuli.my.shop.commoms.validator.BeanValidator;
import com.xianyuli.my.shop.domain.TbContent;
import com.xianyuli.my.shop.web.admin.dao.TbContentDao;
import com.xianyuli.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: TbContentServiceImpl
 * @Description: java类作用描述
 * @Author: LW
 */
@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent,TbContentDao> implements TbContentService {

    @Override
    public BaseResult save(TbContent tbContent) {
        String validMsg = BeanValidator.validator(tbContent);
        if (StringUtils.isNotBlank(validMsg)) {
            return BaseResult.fail(validMsg);
        }else{
            tbContent.setUpdated(new Date());
            //新增内容
            if (tbContent.getId() == null) {
                //密码加密
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            } else {//更新用户
                dao.update(tbContent);
            }
            return BaseResult.success("保存成功");
        }
    }

}
