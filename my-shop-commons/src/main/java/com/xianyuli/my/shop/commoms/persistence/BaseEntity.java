package com.xianyuli.my.shop.commoms.persistence;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;
}
