package com.ruoyi.api.controller;

import com.alibaba.fastjson.JSON;
import com.ruoyi.project.system.MyMessage;

import javax.websocket.DecodeException;
import javax.websocket.EndpointConfig;
import java.util.List;

public class UserDecoder implements javax.websocket.Decoder.Text<MyMessage> {

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }



    @Override
    public MyMessage decode(String message) throws DecodeException {
        System.out.println("message"+message);
        List<MyMessage> list=JSON.parseArray(message,MyMessage.class);
        System.out.println("list"+list);
      return null;

    }

    @Override
    public boolean willDecode(String arg0) {
        return true;
    }

}
