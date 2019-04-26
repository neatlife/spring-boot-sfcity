package com.github.neatlife;

import com.github.neatlife.constant.ApiUrlConstant;
import com.github.neatlife.request.CreateOrderRequest;
import com.github.neatlife.response.CreateOrderResponse;
import com.github.neatlife.response.Response;
import com.github.neatlife.util.HttpUtil;
import com.github.neatlife.util.JsonUtil;

/**
 * @author suxiaolin
 * @date 2019-04-26 12:48
 */
public class SfClient {
    private Integer developerId;

    private String developerKey;

    private String shopId;

    public SfClient(Integer developerId, String developerKey, String shopId) {
        this.developerId = developerId;
        this.developerKey = developerKey;
        this.shopId = shopId;
    }

    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        createOrderRequest.setDevId(developerId);
        createOrderRequest.setShopId(shopId);
        Response response = HttpUtil.post(
                developerId,
                developerKey,
                ApiUrlConstant.getCreateOrderUrl(),
                createOrderRequest
        );
        return JsonUtil.toObject(response.getResult(), CreateOrderResponse.class);
    }
}
