package com.xianyuli.my.shop.domain;

import com.xianyuli.my.shop.commoms.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: TbContentCategory
 * @Description: java类作用描述
 * @Author: LW
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class TbContentCategory extends BaseEntity {
    @Length(min = 1, max = 20, message = "分类名称必须介于 1 - 20 位之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;
}
