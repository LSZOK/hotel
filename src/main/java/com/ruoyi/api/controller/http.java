package com.ruoyi.api.controller;


import com.ruoyi.project.system.domain.SingleSubscribeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class http {

    RestTemplate restTemplate=new RestTemplate();
    public HttpEntity<String> generatePostJson(SingleSubscribeMessage jsonMap) {

        //如果需要其它的请求头信息、都可以在这里追加
        HttpHeaders httpHeaders = new HttpHeaders();

        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");

        httpHeaders.setContentType(type);

        HttpEntity<String> httpEntity = new HttpEntity(jsonMap, httpHeaders);

        return httpEntity;
    }


    /**
     * post请求、请求参数为json
     *
     * @return
     */
    public  String sendPost(String url, SingleSubscribeMessage message) {
        System.out.println("send_post_url:"+url);
        System.out.println("send_post_message:"+message);
        ResponseEntity<String> apiResponse = restTemplate.postForEntity
                (
                        url,
                        generatePostJson(message),
                        String.class
                );
        return apiResponse.getBody();
    }
}
