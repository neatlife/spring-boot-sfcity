package com.github.neatlife.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author suxiaolin
 * @date 2019-04-26 13:40
 */
@Data
public class Response {
    @JsonProperty("error_code")
    private Integer errorCode;

    @JsonProperty("error_msg")
    private String errorMsg;

    /**
     * 详细报错信息（报错的时候非空）
     */
    @JsonProperty("error_data")
    private Object errorData;

    @JsonProperty("result")
    private Object result;
}
