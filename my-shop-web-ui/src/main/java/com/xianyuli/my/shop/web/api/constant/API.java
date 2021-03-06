package com.xianyuli.my.shop.web.api.constant;

public class API {
    public static class Constant{
        //轮播图的父ID
        public static final int PPT_PID = 111;
        //session中user的KEY
        public static final String SESSION_USER = "tbuser";

    }

    public static class Url{
        /**
         * 主机地址
         */
        public static final String HOST = "http://192.168.154.129:8081";
        /**
         * 内容查询
         * /content/v1/{categoryid}
         */
        public static final String API_CONTENT = HOST + "/content/v1/";
        /**
         * 会员管理接口--登录
         * /users/v1/login?username={username}&password={password}
         */
        public static final String API_LOGIN = HOST + "/users/v1/login";
    }

}
