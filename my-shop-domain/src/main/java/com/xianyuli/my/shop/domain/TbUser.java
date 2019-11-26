package com.xianyuli.my.shop.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xianyuli.my.shop.commoms.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonIgnoreProperties(value = {"password"})
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class TbUser extends BaseEntity {
    private String username;
    private String password;
    private String phone;
    private String email;

}
