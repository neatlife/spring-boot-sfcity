package com.github.neatlife.util;

import com.github.neatlife.request.Request;
import com.github.neatlife.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author suxiaolin
 * @date 2019-04-26 13:08
 */
@Slf4j
public class HttpUtil {

    public static Response post(Integer appId, String appSecret, String url, Request request) {
        String content = JsonUtil.toJsonString(request);
        String sign = SignUtil.sign(appId.toString(), appSecret, content);

        url = url + "?sign=" + sign;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<String> httpEntity = new HttpEntity<>(content, headers);
        ResponseEntity<String> httpResponse = restTemplate.postForEntity(url, httpEntity, String.class);

        Response response = JsonUtil.toObject(httpResponse.getBody(), Response.class);

        if (response.getErrorCode() != 0) {
            log.error("errorData: {}", response.getErrorData());
            throw new RuntimeException(response.getErrorMsg());
        }

        return response;
    }

}
