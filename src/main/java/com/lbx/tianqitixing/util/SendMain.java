package com.lbx.tianqitixing.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



import java.util.Map;
@Service
public class SendMain {
    private static final String  JJ="101230509";
    private static final String  FZ="101230103";
    private static final String  PY="101181607";
    public String  senfmessage(String number){
        String url="http://t.weather.sojson.com/api/weather/city/";
        url = url+number;
        String weather = SendUtil.doGet(url);
        JSONObject jsonObject = JSON.parseObject(weather);
        Object o = jsonObject.get("cityInfo");
        JSONObject o1 = (JSONObject)jsonObject.get("data");
        JSONArray json= (JSONArray)o1.get("forecast");
        Map<String,String> map = (Map)o;
        Map<String,String> map1 = (Map)json.getJSONObject(0);
        String message=map.get("parent")+map.get("city")+","+
                map1.get("high")+map1.get("low")+","+"风速："+map1.get("fl")+map1.get("type")+","+map1.get("notice");
        return message;
    }
    //晋江    101230509

    @Scheduled(cron = "0 0 6 * * ?")
    /*@Scheduled(cron="0/2 * * * * *")*/
    public void m(){
        String fzmessage = senfmessage(FZ);
        String xf = "【小熙机器人】张大妞同学，小博熙提醒你，今天"+fzmessage;
        Dxutil.send(xf,"18750712521");
        String pymessage = senfmessage(PY);
        String py = "【小熙机器人】亲爱的老妈，儿子提醒您，今天"+pymessage;
        Dxutil.send(py,"15516682619");
        String jjmessages= senfmessage(JJ);
        String jj = "【小熙机器人】亲爱的老爹，儿子提醒您，今天"+jjmessages;
        Dxutil.send(jj,"15539629555");

    }
}
