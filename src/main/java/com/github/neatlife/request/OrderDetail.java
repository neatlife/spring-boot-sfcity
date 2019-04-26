package com.github.neatlife.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author suxiaolin
 * @date 2019-04-26 13:28
 */
@Data
@Builder
public class OrderDetail {
    /**
     * int(11)	0	是	用户订单总金额（单位：分）
     */
    @JsonProperty("total_price")
    private Integer totalPrice;

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
     * int(11)	0	否	实收用户金额（单位：分）
     */
    @JsonProperty("user_money")
    private Integer userMoney;

    /**
     * int(11)	0	否	实付商户金额（单位：分）
     */
    @JsonProperty("shop_money")
    private Integer shopMoney;

    /**
     * int(11)	0	是	物品重量（单位：克）
     */
    @JsonProperty("weight_gram")
    private Integer weightGram;

    /**
     * int(11)	0	否	物品体积（单位：升）
     */
    @JsonProperty("volume_litre")
    private Integer volumeLitre;

    /**
     * int(11)	0	否	商户收取的配送费（单位：分）
     */
    @JsonProperty("delivery_money")
    private Integer deliveryMoney;

    /**
     * int(11)	0	是	物品个数
     */
    @JsonProperty("product_num")
    private Integer productNum;

    /**
     * int(11)	0	是	物品种类个数
     */
    @JsonProperty("product_type_num")
    private Integer productTypeNum;

    /**
     * Array	空	是	物品详情；数组结构，详见product_detail结构
     */
    @JsonProperty("product_detail")
    private List<ProductDetail> productDetail;
}
