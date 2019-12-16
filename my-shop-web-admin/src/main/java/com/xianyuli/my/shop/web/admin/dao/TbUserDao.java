package com.xianyuli.my.shop.web.admin.dao;

import com.xianyuli.my.shop.commoms.persistence.BaseDao;
import com.xianyuli.my.shop.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: my-shop-modules
 * @Package: com.xianyuli.my.shop.web.admin.dao
 * @ClassName: TbUserDao
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/10/22 0022 23:44
 * @UpdateUser: LW
 * @UpdateDate: 2018/10/22 0022 23:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

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
