package com.xianyuli.my.shop.domain;

import com.xianyuli.my.shop.commoms.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 功能描述: 内容对象<br>
 * 〈〉
 *
 * @return:
 * @Author:LW
 * @Date: 2020/01/12 1:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class TbContent extends BaseEntity {

    /**
    * 内容类目ID
    */
    @NotNull(message = "父级类目不能为空")
    private Long categoryId;

    /**
    * 内容标题
    */
    @Length(min = 2,max = 20,message = "标题长度必须是2到20位")
    private String title;

    /**
    * 子标题
    */
    @Length(min = 2,max = 20,message = "子标题长度必须是2到20位")
    private String subTitle;

    /**
    * 标题描述
    */
    @Length(min = 2,max = 50,message = "标题描述必须是2到50位")
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
    @Length(min = 1,message = "内容不为空")
    private String content;

    private TbContentCategory tbContentCategory;
}