package com.ruoyi.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.*;
import com.ruoyi.project.system.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

@RestController
@RequestMapping("/api")
public class WeixinController extends BaseController {
    @Autowired
    private IRoomInfoService roomInfoService;
    @Autowired
    private IClientService clientService;
    @Autowired
    private IHotelOrderService hotelOrderService;
    @Autowired
    private IRoomTypeService roomTypeService;
    @Autowired
    private IDishesInfoService dishesInfoService;
    @Autowired
    private  IRoomPicturesService roomPicturesService;
    @Autowired
    private  IDinCarService dinCarService;
    @Autowired ICleanRoomService cleanRoomService;
    @Autowired
    private ICleanClothesService cleanClothesService;
    @Autowired
    private  IBaggageDepositService baggageDepositService;
    @Autowired
    private  IPickUpServiceService pickUpServiceService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IHotelContinueService hotelContinueService;
    http http=new http();

    private Logger log= LoggerFactory.getLogger(this.getClass());

    @CrossOrigin
    @GetMapping("/roomInfoList")
    public AjaxResult list(RoomInfo roomInfo)
    {
        List<RoomInfo> list = roomInfoService.selectRoomInfoList(roomInfo);
        return AjaxResult.success(list);
    }

//    @GetMapping("/getClientL")
//    public TableDataInfo list(Client client)
//    {
//        startPage();
//        List<Client> list = clientService.selectClientList(client);
//        return getDataTable(list);
//    }

    @PostMapping("/addOrder")
    public AjaxResult addOrder( @RequestParam("openId") String openId,@RequestParam("clientName") String clientName, @RequestParam("phone")  String phone,@RequestParam("idCard") String idCard,@RequestParam("liveTime") String liveTime, @RequestParam("outTime") String outTime,@RequestParam("sex") String sex,@RequestParam("id") Long id,@RequestParam("price") Long price,@RequestParam("bedType") String bedType){
        String date= DateUtils.dateTimeNow();
        Date addTime=DateUtils.getNowDate();
        Random random=new Random();
        int i=random.nextInt(100);

        String clientId=date+i;

            Client client=new Client();
            client.setClientId(clientId);
            client.setOpenId(openId);
            client.setClientName(clientName);
            client.setSex(sex);
            client.setPhone(phone);
            client.setIdCard(idCard);
            client.setAddTime(addTime);
            clientService.insertClient(client);




        HotelOrder hotelOrder=new HotelOrder();
        int j=random.nextInt(200);
        String orderId=date+j;
        hotelOrder.setOrderId(orderId);
        hotelOrder.setStatus("0");
        hotelOrder.setPrice(price);
        hotelOrder.setRoomType(id);
        hotelOrder.setBedType(bedType);
        hotelOrder.setLiveTime(liveTime);
        hotelOrder.setOutTime(outTime);
        hotelOrder.setClientId(clientId);
        hotelOrder.setAddTime(date);
        hotelOrderService.insertHotelOrder(hotelOrder);

        AjaxResult ajax = new AjaxResult(200,"操作成功");
        return  ajax;
    }

//    添加餐车
    @PostMapping("/addCar")
    public AjaxResult addCar( DinCar dinCar)
    {
        System.out.println("DinCar:"+dinCar);

        return toAjax(dinCarService.insertDinCar(dinCar));
    }
//获取餐车编号
    @GetMapping("/getCarId")
    public AjaxResult GetCarId(){
        AjaxResult ajaxResult=AjaxResult.success();
        String date= DateUtils.dateTimeNow();
        Date addTime=DateUtils.getNowDate();
        Random random=new Random();
        int i=random.nextInt(100)+150;
        String carId=i+date;
        ajaxResult.put("carId",carId);
        return  ajaxResult;
    }
    //获取餐车列表
    @GetMapping("/getCarList")
    public TableDataInfo list(DinCar dinCar)
    {
        List<DinCar> list = dinCarService.selectDinCarList(dinCar);
        return getDataTable(list);
    }
    //修改餐车状态
    @PostMapping("/updateCarStatus")
    public AjaxResult edit( DinCar dinCar)
    {
        return toAjax(dinCarService.updateDinCar(dinCar));
    }
//新增续住信息
@PostMapping("/addContinue")
public AjaxResult add( HotelContinue hotelContinue)
{
    String date= DateUtils.dateTimeNow();
    Date addTime=DateUtils.getNowDate();
    Random random=new Random();
    int i=random.nextInt(100)+100;
    String continueId=i+date;
   hotelContinue.setContinueId(continueId);
      return toAjax(hotelContinueService.insertHotelContinue(hotelContinue));
}
//获取续住信息列表
@GetMapping("/getContinueList")
public TableDataInfo list(HotelContinue hotelContinue)
{
    List<HotelContinue> list = hotelContinueService.selectHotelContinueList(hotelContinue);
    return getDataTable(list);
}

//   获取订单信息
    @PostMapping("/getOrder")
    public TableDataInfo getOrderByOpenIdAndStatus( HotelOrder hotelOrder){
        List<HotelOrder> list = hotelOrderService.selectHotelOrderList(hotelOrder);
        return getDataTable(list);

    }
    /**
     * 获取订单信息详细信息
     */
    @GetMapping("/getOderDetail")
    public AjaxResult getInfo(@RequestParam("orderId") String orderId)
    {
        System.out.println("orderId:"+orderId);
        return AjaxResult.success(hotelOrderService.selectHotelOrderById(orderId));
    }

//    修改订单中的其他费用
@PostMapping("/updateOtherCost")
public AjaxResult edit( HotelOrder hotelOrder)
{

    return toAjax(hotelOrderService.updateHotelOrder(hotelOrder));
}
//获取房间类型
    @PostMapping("/getRoomType")
    public TableDataInfo getOrderByOpenIdAndStatus( RoomType roomType){
        List<RoomType> list = roomTypeService.selectRoomTypeList(roomType);
        return getDataTable(list);

    }

    /*获取菜品信息*/
    @GetMapping("/getDishesList")
    public TableDataInfo list(DishesInfo dishesInfo)
    {
        List<DishesInfo> list = dishesInfoService.selectDishesInfoList(dishesInfo);
        return getDataTable(list);
    }

    /*获取房间图片*/
    @GetMapping("/getRoomPictures")
    public TableDataInfo list(RoomPictures roomPictures)
    {
        List<RoomPictures> list = roomPicturesService.selectRoomPicturesList(roomPictures);
        return getDataTable(list);
    }

    /*获取房间类型信息*/

    @GetMapping("/getRoomTypeList")
    public TableDataInfo list(RoomType roomType) {
        List<RoomType> list = roomTypeService.selectRoomTypeList(roomType);
        System.out.println(getDataTable(list).toString());
        return getDataTable(list);
    }
/*新增清洁信息*/
@PostMapping("/addCleanInfo")
public AjaxResult add( CleanRoom cleanRoom)
{

    String date= DateUtils.dateTime();
    Random random=new Random();
    int i=random.nextInt(250);
    String cleanRoomId=date+i;
    cleanRoom.setCleanRoomId(cleanRoomId);
    cleanRoom.setStatus("0");
    return toAjax(cleanRoomService.insertCleanRoom(cleanRoom));
}
/*获取清洁信息*/
    @GetMapping("/getCleanRoomInfo")
    public TableDataInfo list(CleanRoom cleanRoom)
    {

        List<CleanRoom> list = cleanRoomService.selectCleanRoomList(cleanRoom);
        return getDataTable(list);
    }

    /*新增衣物清洁信息*/
    @PostMapping("/addCleanClothes")
    public AjaxResult add( CleanClothes cleanClothes)
    {
        String date= DateUtils.dateTime();
        Random random=new Random();
        int i=random.nextInt(300);
        String cleanClothesId=date+i;
        cleanClothes.setCleanClothesId(cleanClothesId);
        cleanClothes.setStatus("0");
        return toAjax(cleanClothesService.insertCleanClothes(cleanClothes));
    }

    /**
     * 查询清洁衣物列表
     */

    @GetMapping("/getCleanClothesList")
    public TableDataInfo list(CleanClothes cleanClothes)
    {
        List<CleanClothes> list = cleanClothesService.selectCleanClothesList(cleanClothes);
        return getDataTable(list);
    }
/*查询行李寄存列表*/
    @GetMapping("/getBaggageList")
    public TableDataInfo list(BaggageDeposit baggageDeposit)
    {
        List<BaggageDeposit> list = baggageDepositService.selectBaggageDepositList(baggageDeposit);
        return getDataTable(list);
    }
    /*新增行李寄存信息*/
    @PostMapping("/addBaggage")
    public AjaxResult add( BaggageDeposit baggageDeposit)
    {
        String date= DateUtils.dateTime();
        Random random=new Random();
        int i=random.nextInt(500);
        String baggageId=date+i;
        baggageDeposit.setBaggageId(baggageId);
        return toAjax(baggageDepositService.insertBaggageDeposit(baggageDeposit));
    }
    /*修改行李信息*/
    @PostMapping("/updateBaggage")
    public AjaxResult edit( BaggageDeposit baggageDeposit)
    {
        return toAjax(baggageDepositService.updateBaggageDeposit(baggageDeposit));
    }

    //获取接机服务列表
    @GetMapping("/getPickUpList")
    public TableDataInfo list(PickUpService pickUpService)
    {
        List<PickUpService> list = pickUpServiceService.selectPickUpServiceList(pickUpService);
        return getDataTable(list);
    }

    //新增接机服务信息
    @PostMapping("/addPickUpService")
    public AjaxResult addPickUpService( PickUpService pickUpService)
    {
        String date= DateUtils.dateTime();
        Random random=new Random();
        int i=random.nextInt(700);
        String pickUpId=date+i;
        pickUpService.setPickUpId(pickUpId);
        return toAjax(pickUpServiceService.insertPickUpService(pickUpService));
    }
     /*修改接机信息*/
     @PostMapping("/updatePickUpService")
     public AjaxResult edit(PickUpService pickUpService)
     {
         return toAjax(pickUpServiceService.updatePickUpService(pickUpService));
     }

     /*getSubscribeMessage*/

    @PostMapping("/getSubscribeMessage")
    public  AjaxResult getSubscribeMessage(String openid,String template_id){
        JSONObject json = getAccessToken();
        log.info("json:"+json);
        log.info(json.getString("access_token"));
        log.info("openid:"+openid);
        log.info("template_id:"+template_id);
        send(json.getString("access_token"),openid,template_id);

        return AjaxResult.success(json);
    }

    /*获取access_token*/
    @PostMapping("/getAccessToken")
    public JSONObject getAccessToken() {

        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token";  //请求地址 https://api.weixin.qq.com/sns/jscode2session
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        requestUrlParam.put("appid", "wx76abb4a98c8aa6ff");  //开发者设置中的appId
        requestUrlParam.put("secret", "82de84abe91f765e4619578ed533e5a7"); //开发者设置中的appSecret
        requestUrlParam.put("grant_type", "client_credential");    //默认参数 authorization_code
        JSONObject jsonObject = JSON.parseObject(sendPost(requestUrl, requestUrlParam));
        return jsonObject;
    }

//    public JSONObject getSubscribeMessage(String access_token) {
//
//    }

        public void send(String access_taken,String openid,String template_id){

            Map<String, SubscribeTemplateData> data = new HashMap<>();
            data.put("name1",new SubscribeTemplateData("皇悦酒店"));
            data.put("thing8",new SubscribeTemplateData("客房"));
            data.put("character_string5",new SubscribeTemplateData("123"));
            data.put("phrase6",new SubscribeTemplateData("处理中"));
            data.put("amount2",new SubscribeTemplateData("88"));
            SingleSubscribeMessage message =new SingleSubscribeMessage();
             message.setMiniprogram_state("developer");
             message.setPage("pages/index/index");
             message.setTemplate_id(template_id);
             message.setTouser(openid);
             message.setData(data);

            String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send" ;
            url = url+"?access_token="+access_taken;
            String s=http.sendPost(url,message);
            //解析微信返回数据
            JSONObject json = JSONObject.parseObject(s);
            log.info("send_json:"+json);
            long errcode = json.getLong("errcode");





        }






    /*微信小程序通过code获取openid*/
    @PostMapping("/getId")
    public AjaxResult getWeChatOpenId(@RequestBody JSONObject jsonObject) {
        String code= jsonObject.getString("code");
        JSONObject json = getSessionKeyOropenid(code);
        return AjaxResult.success(json);
    }

    /**
     * 获取微信小程序 session_key 和 openid
     *
     * @param code 调用微信登陆返回的Code
     * @return
     */
    public JSONObject getSessionKeyOropenid(String code) {
        //微信端登录code值
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";  //请求地址 https://api.weixin.qq.com/sns/jscode2session
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        requestUrlParam.put("appid", "wx76abb4a98c8aa6ff");  //开发者设置中的appId
        requestUrlParam.put("secret", "82de84abe91f765e4619578ed533e5a7"); //开发者设置中的appSecret
        requestUrlParam.put("js_code", wxCode); //小程序调用wx.login返回的code
        requestUrlParam.put("grant_type", "authorization_code");    //默认参数 authorization_code
        //发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(sendPost(requestUrl, requestUrlParam));
        return jsonObject;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url 发送请求的 URL
     * @return 所代表远程资源的响应结果
     */
    public String sendPost(String url, Map<String, ?> paramMap) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        String param = "";
        Iterator<String> it = paramMap.keySet().iterator();

        while (it.hasNext()) {
            String key = it.next();
            param += key + "=" + paramMap.get(key) + "&";
        }

        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            // logger.error(e.getMessage(), e);
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
