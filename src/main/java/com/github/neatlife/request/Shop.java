package com.github.neatlife.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author suxiaolin
 * @date 2019-04-26 13:28
 */
@Data
@Builder
public class Shop {
    /**
     * string（64）	空	是	店铺名称
     */
    private String shopName;

    /**
     * string（64）	空	是	店铺电话
     */
    private String shopPhone;

    /**
     * string（255）	空	是	店铺地址
     */
    private String shopAddress;

    /**
     * string（32）	空	否	店铺经度
     */
    private String shopLng;

    /**
     * string（32）	空	否	店铺纬度
     */
    private String shopLat;
}
