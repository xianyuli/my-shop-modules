package com.xianyuli.my.shop.domain;

import java.io.Serializable;

/**
 * @ProjectName: myShop
 * @Package: com.xianyuli.myShop.entity
 * @ClassName: User
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/9/23 0023 0:16
 * @UpdateUser: LW
 * @UpdateDate: 2018/9/23 0023 0:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private boolean isRemember;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRemember() {
        return isRemember;
    }

    public void setRemember(boolean remember) {
        isRemember = remember;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
