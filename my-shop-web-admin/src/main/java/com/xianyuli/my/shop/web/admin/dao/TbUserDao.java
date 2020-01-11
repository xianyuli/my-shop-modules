package com.xianyuli.my.shop.web.admin.dao;

import com.xianyuli.my.shop.commoms.persistence.BaseDao;
import com.xianyuli.my.shop.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    /**
     * 根据姓名查询
     *
     * @param username
     * @return
     */
    List<TbUser> getByUsername(String username);

    /**
     * 根据邮箱查询
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

}
