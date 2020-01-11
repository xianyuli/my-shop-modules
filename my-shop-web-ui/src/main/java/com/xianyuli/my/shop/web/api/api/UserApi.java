package com.xianyuli.my.shop.web.api.api;

import com.xianyuli.my.shop.commoms.utils.HttpClientUtils;
import com.xianyuli.my.shop.commoms.utils.MapperUtils;
import com.xianyuli.my.shop.web.api.constant.API;
import com.xianyuli.my.shop.web.api.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class UserApi {

    public static TbUser login(TbUser user) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", user.getUsername()));
        params.add(new BasicNameValuePair("password", user.getPassword()));
        String result = HttpClientUtils.doPost(API.Url.API_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        return MapperUtils.json2pojoByTree(result, "data", TbUser.class);
    }

}
