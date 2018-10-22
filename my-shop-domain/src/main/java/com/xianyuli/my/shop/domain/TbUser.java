package com.xianyuli.my.shop.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: my-shop-modules
 * @Package: com.xianyuli.my.shop.domain
 * @ClassName: TbUser
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2018/10/22 0022 23:30
 * @UpdateUser: LW
 * @UpdateDate: 2018/10/22 0022 23:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Setter
@Getter
@ToString
public class TbUser implements Serializable{
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date update;
}
