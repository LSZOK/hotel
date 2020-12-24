package com.ruoyi.api.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.MyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
//在@ServerEndpoint中指定了decoders和encoders
@ServerEndpoint(value = "/websocket/{myUserId}") //接受websocket请求路径
@Component  //注册到spring容器中
public class MyWebSocket {


    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //存放用户的id与session关系
    private static HashMap<String, Session> map = new HashMap();

    private Logger log =  LoggerFactory.getLogger(this.getClass());
    private String myUserId="";
    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("myUserId") String myUserId, Session session) {
        if (myUserId != null) {
            //从url中获取当前用户的id和其session做对应
            map.put(myUserId, session);
            this.myUserId=myUserId;
        }
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());

        log.info("myUserId:"+myUserId);
        for(Map.Entry<String, Session> entry : map.entrySet()){
            String mapKey = entry.getKey();
            Session mysession = entry.getValue();
            System.out.println(mapKey+":"+mysession.getId());
        }
//        try {
//            sendMessage("连接成功", session);
//        } catch (IOException e) {
//            System.out.println("websocket IO异常");
//        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        Collection<Session> values = map.values();
        values.remove(this);//从map中移除用户session
        map.remove(this);
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount()+" "+"关闭链接："+this.myUserId);
        for(Map.Entry<String, Session> entry : map.entrySet()){
            String mapKey = entry.getKey();
            Session session = entry.getValue();
            System.out.println(mapKey+":"+session.getId());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message,Session session) {
        log.info("收到来自窗口" + myUserId + "的信息:" + message);
        //log.info("onMessage:"+myMessage,"session:"+session);
        JSONObject jsonObject= JSON.parseObject(message);
        log.info("jsonObject:"+jsonObject);
        String to= jsonObject.getString("to");
        String msg=jsonObject.getString("msg");
        log.info("to:"+to);
        try {
            Session session1 =map.get(to);
            if (session1 == null) {
                sendMessage("该用户不在线", session);
            } else {
                System.out.println("发送消息:"+msg);
                sendMessage(msg, session1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String[] split = message.split("-");//获取用户发送的信息和发送人id
//        System.out.println("来自客户端的消息:" + split[0]);
//        try {
//            Session session1 = map.get(split[1]);
//            if (session1 == null) {
//                sendMessage("该用户不在线", session);
//            } else {
//                System.out.println("发送消息:"+split[0]);
//                sendMessage(split[0], session1);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        return  myMessage;
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    /**
     * 通过session确认给谁发信息
     *
     * @param session
     * @param message
     */
    public void sendMessage(String message, Session session) throws IOException {
        log.info("session:"+session.getId());
        session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     */

    public  void sendInfo(String message) throws IOException {

//        JSONObject jsonObject= JSON.parseObject(message);
//        System.out.println("jsonObject:"+jsonObject);
//        String to= jsonObject.getString("to");
//        String msg=jsonObject.getString("msg");
//        System.out.println("推送消息到窗口" + to + "，推送内容:" + msg);
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("消息推送失败");
            e.printStackTrace();
        }
       /* for (MyWebSocket item : webSocketSet) {
            //这里可以设定只推送给这个sid的，为null则全部推送
            if (to == null) {
                item.sendMyMessage(message);
            } else if (item.myUserId.equals(to)) {
                item.sendMyMessage(message);
            }
        }*/



       // System.out.println(message);
      /*  for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessage(message, item.session);
            } catch (IOException e) {
                continue;
            }
        }*/
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMyMessage(String message) throws  Exception {
        JSONObject jsonObject= JSON.parseObject(message);
        System.out.println("jsonObject:"+jsonObject);
        String to= jsonObject.getString("to");
        String msg=jsonObject.getString("msg");
        System.out.println("推送消息到窗口" + to + "，推送内容:" + msg);
//        for (MyWebSocket item : webSocketSet) {
//            System.out.println(item);
//             item.sendInfo("123");
//
//        }

        for (MyWebSocket item : webSocketSet) {
            //这里可以设定只推送给这个sid的，为null则全部推送
            if (to == null) {
                item.sendInfo(msg);
            } else if (item.myUserId.equals(to)) {
                item.sendInfo(msg);
            }
        }

    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }
}