package com.github.neatlife.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author suxiaolin
 * @date 2019-04-26 12:42
 */
@Data
public class CreateOrderRequest extends Request {
    //	int（11）	0	是	同城开发者ID	可在顺丰同城开放平台上自助申请
    @JsonProperty("dev_id")
    private Integer devId;

    // 	string（64）	0	是	店铺ID
    @JsonProperty("shop_id")
    private String shopId;

    // 	int(11)	1	否	店铺ID类型	1：顺丰店铺ID ；2：接入方店铺ID
    @JsonProperty("shop_type")
    private Integer shopType;

    /**
     * string(128)	空	是	商家订单号	不允许重复
     */
    @JsonProperty("shop_order_id")
    private String shopOrderId;

    /**
     * string(12)	空	是	订单接入来源	1：美团；2：饿了么；3：百度；4：口碑；其他请直接填写中文字符串值
     */
    @JsonProperty("order_source")
    private String orderSource;

    /**
     * string(12)	空	否	取货序号	与order_source配合使用
     * 如：饿了么10号单，表示如下：
     * order_source=2;order_sequence=10。
     * 用于骑士快速寻找配送物
     */
    @JsonProperty("order_sequence")
    private String orderSequence;

    /**
     * int（2）	2	否	坐标类型	1：百度坐标，2：高德坐标
     */
    @JsonProperty("lbs_type")
    private Integer lbsType;

    /**
     * int（11）	1	是	用户支付方式	1：已付款 0：货到付款
     */
    @JsonProperty("pay_type")
    private Integer payType;

    /**
     * int（11）	0	否	代收金额	单位：分
     */
    @JsonProperty("receive_user_money")
    private Integer receiveUserMoney;

    /**
     * int（11）	0	是	用户下单时间	秒级时间戳
     */
    @JsonProperty("order_time")
    private Integer orderTime;

    /**
     * int（2）	0	是	是否是预约单	0：非预约单；1：预约单
     */
    @JsonProperty("is_appoint")
    private Integer isAppoint;

    /**
     * int（11）	0	否	用户期望送达时间	预约单需必传,秒级时间戳
     */
    @JsonProperty("expect_time")
    private Integer expectTime;
    /**
     * int（11）	0	是	是否保价，0：非保价；1：保价
     */
    @JsonProperty("is_insured")
    private Integer isInsured;

    /**
     * int（11）	0	否	保价金额	单位：分
     */
    @JsonProperty("declared_value")
    private Integer declaredValue;

    /**
     * string（1024）	空	否	订单备注
     */
    @JsonProperty("remark")
    private String remark;

    /**
     * int（11）	1	否	物流流向	1：从门店取件送至用户；
     * 2：从用户取件送至门店
     */
    @JsonProperty("rider_pick_method")
    private Integer riderPickMethod;

    /**
     * int	1	否	返回字段控制标志位（二进制）	1：价格，2：距离，4：重量，组合条件请相加
     * 例如全部返回为填入7
     */
    @JsonProperty("return_flag")
    private Integer returnFlag;

    /**
     * int（11）	0	是	推单时间	秒级时间戳
     */
    @JsonProperty("push_time")
    private Integer pushTime;

    /**
     * int（11）	0	是	版本号	参照文档主版本号填写
     * 如：文档版本号1.7,version=17
     */
    @JsonProperty("version")
    private Integer version;

    /**
     * OBJ	空	是	收货人信息	Obj，详见receive结构
     */
    @JsonProperty("receive")
    private Receive receive;

    /**
     * OBJ	空	否	发货店铺信息	Obj，详见shop结构，
     * 平台级开发者（如饿了么）需传入
     * 如无特殊说明此字段可忽略
     */
    @JsonProperty("shop")
    private Shop shop;

    /**
     * OBJ	空	是	订单详情	Obj，详见order_detail结构
     */
    @JsonProperty("order_detail")
    private OrderDetail orderDetail;

}
