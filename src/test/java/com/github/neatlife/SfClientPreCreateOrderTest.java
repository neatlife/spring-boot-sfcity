package com.github.neatlife;

import com.github.neatlife.constant.ApiUrlConstant;
import com.github.neatlife.request.*;
import com.github.neatlife.response.PreCreateOrderResponse;
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
public class SfClientPreCreateOrderTest {

    @Autowired
    SfClient sfClient;

    @Test
    public void preCreateOrder() {
        PreCreateOrderResponse preCreateOrderResponse = sfClient.preCreateOrder(createPreOrderRequest());

        Assert.assertNotNull(preCreateOrderResponse);
    }

    private CreateOrderRequest createPreOrderRequest() {
        PreCreateOrderRequest preCreateOrderRequest = new PreCreateOrderRequest();
        preCreateOrderRequest.setProductType(1);
        preCreateOrderRequest.setUserLng("116.3534196");
        preCreateOrderRequest.setUserLat("40.0159778");
        preCreateOrderRequest.setUserAddress("123456");
        preCreateOrderRequest.setShopOrderId(System.currentTimeMillis() + "");
        preCreateOrderRequest.setOrderSource("测试");
        preCreateOrderRequest.setPayType(1);
        preCreateOrderRequest.setOrderTime(DateUtil.currentSecond().intValue());
        preCreateOrderRequest.setIsAppoint(0);
        preCreateOrderRequest.setIsInsured(0);
        preCreateOrderRequest.setRiderPickMethod(1);
        preCreateOrderRequest.setPushTime(DateUtil.currentSecond().intValue());
        preCreateOrderRequest.setVersion(17);
        preCreateOrderRequest.setShop(
                Shop.builder()
                        .shopName("店铺名")
                        .shopPhone("13266666666")
                        .shopAddress("朝阳区高碑店镇四惠大厦F1-008")
                        .shopLng("116.514236")
                        .shopLat("39.905328")
                        .build()
        );
        preCreateOrderRequest.setReceive(
                Receive.builder()
                        .userName("小明")
                        .userPhone("13288888888")
                        .userLng("116.3534196")
                        .userLat("40.0159778")
                        .userAddress("朝阳区高碑店镇四惠大厦F1-008")
                        .cityName("北京市")
                        .build()
        );
        preCreateOrderRequest.setOrderDetail(
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
        return preCreateOrderRequest;
    }
}