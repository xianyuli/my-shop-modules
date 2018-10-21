package com.xianyuli.my.shop.web.admin.service.impl;

import com.xianyuli.my.shop.domain.User;
import com.xianyuli.my.shop.web.admin.dao.UserDao;
import com.xianyuli.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: myShop
 * @Package: com.xianyuli.myShop.service.impl
 * @ClassName: UserServiceimpl
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/9/23 0023 0:40
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/23 0023 0:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service(value = "userService")
public class UserServiceimpl implements UserService {
    /**
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    @Autowired
    UserDao userDao;

    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
