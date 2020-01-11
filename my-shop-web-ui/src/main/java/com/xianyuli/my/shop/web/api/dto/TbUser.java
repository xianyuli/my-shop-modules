package com.xianyuli.my.shop.web.api.dto;

import com.xianyuli.my.shop.commoms.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @ClassName: Tbuser
 * @Description: java类作用描述
 * @Author: LW
 */
@Data
public class TbUser implements Serializable {
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verification;
}
