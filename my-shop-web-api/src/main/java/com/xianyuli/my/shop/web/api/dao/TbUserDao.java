package com.xianyuli.my.shop.web.api.dao;

import com.xianyuli.my.shop.commoms.persistence.BaseDao;
import com.xianyuli.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述: 会员管理
 * 〈〉
 *
 * @return:
 * @Author:LW
 * @Date: 2020/01/09 22:48
 */
@Repository
public interface TbUserDao {

    TbUser login(TbUser user);

}
