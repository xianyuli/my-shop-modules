package com.xianyuli.my.shop.web.admin.dao;


import com.xianyuli.my.shop.domain.User;

/**
 * @ProjectName: my-Shop
 * @Package: com.xianyuli.myShop.dao
 * @ClassName: UserDao
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/9/23 0023 0:19
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/23 0023 0:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface UserDao {

    public User getUser(String email, String password);
}
