package com.xianyuli.my.shop.web.admin.service;


import com.xianyuli.my.shop.domain.User;

/**
 * @ProjectName: my-Shop
 * @Package: com.xianyuli.myShop.service
 * @ClassName: UserService
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/9/23 0023 0:37
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/23 0023 0:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface UserService {
    public User login(String email, String password);

}
