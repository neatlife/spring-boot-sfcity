package com.github.neatlife;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author suxiaolin
 * @date 2019-04-26 12:46
 */
@ConfigurationProperties(prefix = "sfcity")
@Data
public class Properties {

    private Integer developerId;

    private String developerKey;

    private String shopId;

    private String apiUrl;

}