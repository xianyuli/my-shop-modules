package com.xianyuli.my.shop.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xianyuli.my.shop.commoms.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import com.xianyuli.my.shop.commoms.utils.RegexpUtils;

import javax.validation.constraints.Pattern;

@JsonIgnoreProperties(value = {"password"})
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class TbUser extends BaseEntity {
    @Length(min = 6, max = 20, message = "姓名长度必须是2到20位")
    private String username;
    @Length(min = 6, max = 30, message = "密码长度必须是6到20位")
    private String password;
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机格式不正确")
    private String phone;
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;

}
