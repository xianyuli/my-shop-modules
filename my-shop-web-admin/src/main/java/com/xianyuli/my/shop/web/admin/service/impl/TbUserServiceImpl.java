package com.xianyuli.my.shop.web.admin.service.impl;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.xianyuli.my.shop.commoms.validator.BeanValidator;
import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.admin.dao.TbUserDao;
import com.xianyuli.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser,TbUserDao> implements TbUserService {

    @Override
    public BaseResult save(TbUser tbUser) {
        String validMsg = BeanValidator.validator(tbUser);
        if (StringUtils.isNotBlank(validMsg)) {
            return BaseResult.fail(validMsg);
        } else {
            validMsg = checkTbUser(tbUser);
            if (StringUtils.isNotBlank(validMsg)) {
                return BaseResult.fail(validMsg);
            }
            tbUser.setUpdated(new Date());
            //新增用户
            if (tbUser.getId() == null) {
                //密码加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                dao.insert(tbUser);
            } else {//更新用户
                dao.update(tbUser);
            }
            return BaseResult.success("保存成功");
        }
    }


    @Override
    public List<TbUser> getByUsername(String username) {
        return dao.getByUsername(username);
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = dao.getByEmail(email);
        if (tbUser != null) {
            String pwd = tbUser.getPassword();
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (pwd.equals(md5Password)) {
                return tbUser;
            }
        }

        return null;
    }

    /**
     * 功能描述: 用户有效性验证<br>
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/11/11 0011 16:55
     */
    private String checkTbUser(TbUser tbUser) {
        BaseResult baseResult = BaseResult.success();
        if (tbUser.getId() == null) {
            //用户信息唯一性验证
            List<TbUser> list = getByUsername(tbUser.getUsername());
            if (!list.isEmpty()) {
                return String.format("用户名%s已存在", tbUser.getUsername());
            }
        }
        return null;

    }


}
