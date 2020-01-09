package com.xianyuli.my.shop.web.api.service.impl;

import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.api.dao.TbUserDao;
import com.xianyuli.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    TbUserDao tbUserDao;


    @Override
    public TbUser login(TbUser user) {
        if (user != null) {
            String md5PassWord = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
            TbUser currentUser = tbUserDao.login(user);
            if (currentUser != null && md5PassWord.equals(currentUser.getPassword())) {
                return currentUser;
            }
        }
        return null;
    }
}
