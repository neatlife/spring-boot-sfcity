package com.github.neatlife.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author suxiaolin
 * @date 2019-04-26 13:37
 */
@Data
@Builder
public class ProductDetail {
    /**
     * string(64)	空	是	物品名称
     */
    @JsonProperty("product_name")
    private String productName;

    /**
     * int(11)	0	否	物品ID
     */
    @JsonProperty("product_id")
    private String productId;

    /**
     * int(11)	0	是	物品数量
     */
    @JsonProperty("product_num")
    private Integer productNum;

    /**
     * int(11)	0	否	物品价格
     */
    @JsonProperty("product_price")
    private String productPrice;

    /**
     * string(64)	空	否	物品单位
     */
    @JsonProperty("product_unit")
    private String productUnit;

    /**
     * string(256)	空	否	备注
     */
    @JsonProperty("product_remark")
    private String productRemark;

    /**
     * string(1024)	空	否	详情
     */
    @JsonProperty("item_detail")
    private String itemDetail;

}
