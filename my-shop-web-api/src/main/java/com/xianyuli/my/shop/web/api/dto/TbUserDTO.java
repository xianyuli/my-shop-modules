package com.xianyuli.my.shop.web.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbUserDTO implements Serializable {
    private String username;
    private String phone;
    private String email;

}
