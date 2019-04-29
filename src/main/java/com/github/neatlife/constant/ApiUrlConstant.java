package com.github.neatlife.constant;

/**
 * @author suxiaolin
 * @date 2019-04-26 11:31
 */
public class ApiUrlConstant {

    private static String sfCityHost;

    private static final String CREATE_ORDER_URL = "/open/api/external/createorder";

    private static final String PRE_CREATE_ORDER_URL = "/open/api/external/precreateorder";

    public static String getCreateOrderUrl() {
        return sfCityHost + CREATE_ORDER_URL;
    }

    public static String getPreCreateOrderUrl() {
        return sfCityHost + PRE_CREATE_ORDER_URL;
    }

    public static void setSfCityHost(String sfCityHost) {
        ApiUrlConstant.sfCityHost = sfCityHost;
    }
}
