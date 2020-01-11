package com.xianyuli.my.shop.commoms.persistence;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * 功能描述: 业务对象基类<br>
 * 〈〉
 * 
 * @return:
 * @Author:LW
 * @Date: 2020/01/12 1:22
 */
@Data
public class BaseEntity implements Serializable {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updated;
}
