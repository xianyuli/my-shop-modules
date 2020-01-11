package com.xianyuli.my.shop.web.api.dao;

import com.xianyuli.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserDao {

    TbUser login(TbUser user);

}
