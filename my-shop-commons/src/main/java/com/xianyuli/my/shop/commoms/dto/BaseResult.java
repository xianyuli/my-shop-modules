package com.xianyuli.my.shop.commoms.dto;

import com.xianyuli.my.shop.commoms.utils.ConstantUtils;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 功能描述: 接口统一返回对象<br>
 * 〈〉
 *
 * @return:
 * @Author:LW
 * @Date: 2020/01/12 1:22
 */
@Setter
@Getter
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = ConstantUtils.STATUS_SUCCESS;
    public static final int STATUS_FAIL = ConstantUtils.STATUS_FAIL;

    private int status;
    private  String msg;
    private Object data;

    public static BaseResult success() {
        return BaseResult.createResult(STATUS_SUCCESS, "操作成功", null);
    }

    public static BaseResult success(String message) {
        return BaseResult.createResult(STATUS_SUCCESS, message, null);
    }

    public static BaseResult success(String message, Object data) {
        return BaseResult.createResult(STATUS_SUCCESS, message, data);
    }

    public static BaseResult fail() {
        return BaseResult.createResult(STATUS_FAIL, "操作失败", null);
    }

    public static BaseResult fail(String message) {
        return BaseResult.createResult(STATUS_FAIL, message, null);
    }

    public static BaseResult fail(int status, String message) {
        return BaseResult.createResult(status, message, null);
    }
    private static BaseResult createResult(int status, String message, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMsg(message);
        baseResult.setData(data);
        return baseResult;
    }


}
