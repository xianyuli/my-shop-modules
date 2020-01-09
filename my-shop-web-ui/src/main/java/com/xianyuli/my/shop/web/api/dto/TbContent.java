package com.xianyuli.my.shop.web.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: TbContent
 * @Description: java类作用描述
 * @Author: LW
 */
@Data
public class TbContent implements Serializable {
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
