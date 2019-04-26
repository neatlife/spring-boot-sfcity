package com.github.neatlife.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author suxiaolin
 * @date 2019-04-26 13:28
 */
@Data
@Builder
public class Receive {
    /**
     * string（64）	空	是	用户姓名
     */
    @JsonProperty("user_name")
    private String userName;

    /**
     * string（64）	空	是	用户电话
     */
    @JsonProperty("user_phone")
    private String userPhone;

    /**
     * string（255）	空	是	用户地址
     */
    @JsonProperty("user_address")
    private String userAddress;

    /**
     * string（32）	空	是	用户经度
     */
    @JsonProperty("user_lng")
    private String userLng;

    /**
     * string（32）	空	是	用户纬度
     */
    @JsonProperty("user_lat")
    private String userLat;

    /**
     * string（32）	空	否	发单城市	用来校验是否跨城；请填写城市的中文名称，如北京市、深圳市
     */
    @JsonProperty("city_name")
    private String cityName;
}
