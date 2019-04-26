package com.github.neatlife;

import com.github.neatlife.constant.ApiUrlConstant;
import com.github.neatlife.request.*;
import com.github.neatlife.response.CreateOrderResponse;
import com.github.neatlife.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author suxiaolin
 * @date 2019-04-26 12:36
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AutoConfiguration.class, ApiUrlConstant.class})
@TestPropertySource("classpath:application.properties")
@ProfileValueSourceConfiguration
public class SfClientTest {

    @Autowired
    SfClient sfClient;

    @Test
    public void createOrder() {
        CreateOrderResponse createOrderResponse = sfClient.createOrder(createOrderRequest());

        Assert.assertNotNull(createOrderResponse.getSfOrderId());
    }

    private CreateOrderRequest createOrderRequest() {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setShopOrderId(System.currentTimeMillis() + "");
        createOrderRequest.setOrderSource("测试");
        createOrderRequest.setPayType(1);
        createOrderRequest.setOrderTime(DateUtil.currentSecond().intValue());
        createOrderRequest.setIsAppoint(0);
        createOrderRequest.setIsInsured(0);
        createOrderRequest.setRiderPickMethod(1);
        createOrderRequest.setPushTime(DateUtil.currentSecond().intValue());
        createOrderRequest.setVersion(17);
        createOrderRequest.setShop(
                Shop.builder()
                        .shopName("店铺名")
                        .shopPhone("13266666666")
                        .shopAddress("朝阳区高碑店镇四惠大厦F1-008")
                        .shopLng("116.514236")
                        .shopLat("39.905328")
                        .build()
        );
        createOrderRequest.setReceive(
                Receive.builder()
                        .userName("小明")
                        .userPhone("13288888888")
                        .userPhone("北京")
                        .userLng("116.3534196")
                        .userLat("40.0159778")
                        .userAddress("朝阳区高碑店镇四惠大厦F1-008")
                        .cityName("北京市")
                        .build()
        );
        createOrderRequest.setOrderDetail(
                OrderDetail.builder()
                        .totalPrice(100)
                        .productType(1)
                        .weightGram(500)
                        .productNum(1)
                        .productTypeNum(1)
                        .productDetail(
                                Stream.of(
                                        ProductDetail.builder()
                                                .productName("小炒肉")
                                                .productNum(1)
                                                .build()
                                ).collect(Collectors.toList())
                        )
                        .build()
        );
        return createOrderRequest;
    }
}