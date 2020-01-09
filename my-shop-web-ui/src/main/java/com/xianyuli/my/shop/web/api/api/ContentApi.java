package com.xianyuli.my.shop.web.api.api;

import com.xianyuli.my.shop.commoms.utils.HttpClientUtils;
import com.xianyuli.my.shop.commoms.utils.MapperUtils;
import com.xianyuli.my.shop.web.api.constant.API;
import com.xianyuli.my.shop.web.api.dto.TbContent;

import java.util.List;

/**
 * @ClassName: ContentApi
 * @Description: java类作用描述
 * @Author: LW
 */
public class ContentApi {

    public static List<TbContent> ppt(long categoryId) {
        String result = HttpClientUtils.doGet(API.Url.API_CONTENT + categoryId);
        try {
            return  MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
