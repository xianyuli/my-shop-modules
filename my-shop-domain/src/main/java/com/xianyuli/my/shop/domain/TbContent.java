package com.xianyuli.my.shop.domain;

import com.xianyuli.my.shop.commoms.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**     
  * 
  * @ClassName:     TbContent
  * @Description:   java类作用描述 
  * @Author:         LW
  *
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class TbContent extends BaseEntity {

    /**
    * 内容类目ID
    */
    private Long categoryId;

    /**
    * 内容标题
    */
    private String title;

    /**
    * 子标题
    */
    private String subTitle;

    /**
    * 标题描述
    */
    private String titleDesc;

    /**
    * 链接
    */
    private String url;

    /**
    * 图片绝对路径
    */
    private String pic;

    /**
    * 图片2
    */
    private String pic2;

    /**
    * 内容
    */
    private String content;
}