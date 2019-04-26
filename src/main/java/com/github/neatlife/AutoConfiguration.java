package com.github.neatlife;

import com.github.neatlife.constant.ApiUrlConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suxiaolin
 * @date 2019-04-26 12:42
 */
@Configuration
@EnableConfigurationProperties(Properties.class)
@Slf4j
public class AutoConfiguration {

    private Properties sfCityProperties;

    @Autowired
    public AutoConfiguration(Properties sfCityProperties) {
        this.sfCityProperties = sfCityProperties;

        ApiUrlConstant.setSfCityHost(sfCityProperties.getApiUrl());
    }

    @Bean
    @ConditionalOnMissingBean
    public SfClient sfClient() {
        SfClient sfClient = new SfClient(
                sfCityProperties.getDeveloperId(),
                sfCityProperties.getDeveloperKey(),
                sfCityProperties.getShopId()
        );
        return sfClient;
    }
}
