package com.github.neatlife.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author suxiaolin
 * @date 2019-04-28 8:03
 */
@Data
public class PreCreateOrderRequest extends CreateOrderRequest {

    /**
     * int(11)	0	是	物品类型	1快餐;2送药;3百货;
     * 4脏衣服收;5干净衣服派;6生鲜;
     * 7保单;8饮品;9现场勘查;
     * 10快递;12文件证照;13蛋糕;
     * 14鲜花;15电子数码;16服装鞋帽;
     * 17汽车配件;18珠宝;20披萨;
     * 21中餐;99其他
     */
    @JsonProperty("product_type")
    private Integer productType;

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
     * string（255）	空	是	用户地址
     */
    @JsonProperty("user_address")
    private String userAddress;
}
