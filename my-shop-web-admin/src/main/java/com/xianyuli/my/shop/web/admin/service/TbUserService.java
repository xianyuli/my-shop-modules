package com.xianyuli.my.shop.web.admin.service;

import com.xianyuli.my.shop.commoms.persistence.BaseService;
import com.xianyuli.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService extends BaseService<TbUser> {

    List<TbUser> getByUsername(String username);

    TbUser login(String email, String password);

}
