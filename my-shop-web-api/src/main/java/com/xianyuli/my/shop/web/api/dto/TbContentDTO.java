package com.xianyuli.my.shop.web.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbContentDTO implements Serializable {
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
