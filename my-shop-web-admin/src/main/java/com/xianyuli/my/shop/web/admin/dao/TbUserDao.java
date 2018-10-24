package com.xianyuli.my.shop.web.admin.dao;

import com.xianyuli.my.shop.domain.TbUser;
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
public interface TbUserDao {
    /**
     * 查询全部用户信息
     * @return
     */
    List<TbUser> selectAll();

    void insert(TbUser tbUser);

    void delete(long id);

    TbUser getById(long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    TbUser getByEmail(String email);
}
