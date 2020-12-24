package com.ruoyi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myWebSocket")
public class WebSocketController {
    @Autowired
    MyWebSocket webSocketServer;

    @PostMapping("/server/push")
    public void push(String msg) {

          try {
              System.out.println("msg"+msg);
              webSocketServer.sendMyMessage(msg);
          }
          catch (Exception e){
              e.printStackTrace();
          }


    }
}
