package com.github.neatlife.response;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

/**
 * @author suxiaolin
 * @date 2019-04-26 12:42
 */
@Data
public class PreCreateOrderResponse {

    /**
     * 0：预约送达单 1：立即单 3：预约上门单
     */
    @JsonProperty("delivery_type")
    private Integer deliveryType;

    /**
     * 预计送达（上门）时间
     */
    @JsonProperty("expec_time")
    private Integer expecTime;

    /**
     * 预计开始配送的时间
     */
    @JsonProperty("start_time")
    private Integer startTime;

    /**
     * 预计配送时间（单位: 分）
     */
    @JsonProperty("promise_delivery_time")
    private Integer promiseDeliveryTime;

    /**
     * 配送距离
     */
    @JsonProperty("delivery_distance_meter")
    private Integer deliveryDistanceMeter;

}
