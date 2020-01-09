package com.xianyuli.my.shop.web.api.api;

import com.xianyuli.my.shop.commoms.dto.BaseResult;
import com.xianyuli.my.shop.commoms.utils.HttpClientUtils;
import com.xianyuli.my.shop.commoms.utils.MapperUtils;
import com.xianyuli.my.shop.domain.TbUser;
import com.xianyuli.my.shop.web.api.constant.API;
import com.xianyuli.my.shop.web.api.dto.TbContent;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserApi
 * @Description: java类作用描述
 * @Author: LW
 */
public class UserApi {

    public static TbUser login(TbUser user) {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", user.getUsername()));
        params.add(new BasicNameValuePair("password", user.getPassword()));
        String result = HttpClientUtils.doPost(API.Url.API_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        try {
            return MapperUtils.json2pojoByTree(result, "data", TbUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
