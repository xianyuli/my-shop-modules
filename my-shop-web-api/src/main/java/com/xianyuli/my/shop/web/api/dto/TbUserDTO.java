package com.xianyuli.my.shop.web.api.dto;

import com.xianyuli.my.shop.commoms.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @ClassName: TbUserDTO
 * @Description: java类作用描述
 * @Author: LW
 */
@Data
public class TbUserDTO implements Serializable {
    private String username;
    private String phone;
    private String email;

}
