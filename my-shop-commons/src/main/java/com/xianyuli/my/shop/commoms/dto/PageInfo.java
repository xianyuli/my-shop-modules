package com.xianyuli.my.shop.commoms.dto;

import com.xianyuli.my.shop.commoms.persistence.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页传输对象
 * @param <T>
 */
@Data
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;
}
