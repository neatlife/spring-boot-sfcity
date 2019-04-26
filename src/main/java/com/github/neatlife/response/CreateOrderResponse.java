package com.github.neatlife.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author suxiaolin
 * @date 2019-04-26 12:42
 */
@Data
public class CreateOrderResponse {
    /**
     * 3165848793513984",//顺丰订单号（标准默认为int，可以设置为string）
     */
    @JsonProperty("sf_order_id")
    private String sfOrderId;

    /**
     * 509008343346",//顺丰运单号（需要设置）
     */
    @JsonProperty("sf_bill_id")
    private Integer sfBillId;

    /**
     * 15104092022333",//商家订单号
     */
    @JsonProperty("shop_order_id")
    private String shopOrderId;

    /**
     * 1510680568" //推送时间
     */
    @JsonProperty("push_time")
    private Integer pushTime;

    /**
     * 以下字段受请求参数中 return_flag 控制：return_flag中未包含的，此字段将不存在，请注意！
     * 1300, //配送费价格，当return_flag中包含1时返回，单位分（值为计算出来此单总价）
     */
    @JsonProperty("total_price")
    private Integer totalPrice;

    /**
     * 1234, //配送距离，当return_flag中包含2时返回，单位米（值为计算出来实际配送距离）
     */
    @JsonProperty("delivery_distance_meter")
    private Integer deliveryDistanceMeter;

    /**
     * 1000, //商品重量，当return_flag中包含4时返回，单位克（值为下单传入参数回传）
     */
    @JsonProperty("weight_gram")
    private Integer weightGram;

}
