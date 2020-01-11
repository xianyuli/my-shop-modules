package com.xianyuli.my.shop.web.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbUser implements Serializable {
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verification;
}
