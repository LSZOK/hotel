package com.ruoyi.api.controller;

import com.alibaba.fastjson.JSON;
import com.ruoyi.project.system.MyMessage;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;

public class UserEncoder implements javax.websocket.Encoder.Text<MyMessage> {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(EndpointConfig arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public String encode(MyMessage message) throws EncodeException {
        return JSON.toJSONString(message);
    }

}