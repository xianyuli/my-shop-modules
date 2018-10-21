package com.xianyuli.my.shop.web.admin.dao.impl;

import com.xianyuli.my.shop.domain.User;
import com.xianyuli.my.shop.web.admin.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: myShop
 * @Package: com.xianyuli.myShop.dao.impl
 * @ClassName: UserDaoimpl
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/9/23 0023 0:20
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/23 0023 0:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Repository(value = "userDao")
public class UserDaoimpl implements UserDao {
    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @return:
     * @Author:LW
     * @Date: 2018/9/23 0023 0:30
     */
    public User getUser(String email, String password) {
        User user = null;
        if ("admin@xianyuli.com".equals(email)) {
            if ("admin".equals(password)) {
                user = new User();
                user.setEmail("admin@xianyuli.com");
                user.setUsername("admin");
            }
        }
        return user;
    }
}
