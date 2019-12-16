package com.xianyuli.my.shop.commoms.dto;

import com.xianyuli.my.shop.commoms.utils.ConstantUtils;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ProjectName: my-shop-modules
 * @Package: com.xianyuli.my.shop.commoms.dto
 * @ClassName: BaseResult
 * @Description:
 * @Author: LW
 * @CreateDate: 2018/11/11 0011 17:00
 * @UpdateUser: LW
 * @UpdateDate: 2018/11/11 0011 17:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Setter
@Getter
public class BaseResult implements Serializable {
    private int status;
    private  String msg;
    private Object data;

    public static BaseResult success(){
        return createResult(ConstantUtils.STATUS_SUCCESS,"成功");
    }

    public static BaseResult success(String msg){
        return createResult(ConstantUtils.STATUS_SUCCESS, msg);
    }

    public static BaseResult fail(){
        return createResult(ConstantUtils.STATUS_FAIL, "失败");
    }

    public static BaseResult fail(String msg){
        return createResult(ConstantUtils.STATUS_FAIL, msg);
    }

    public static BaseResult fail(int status, String msg) {
        return createResult(status, msg);
    }

    private static BaseResult createResult(int status,String msg) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMsg(msg);
        return  baseResult;
    }


}
