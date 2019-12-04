package com.lbx.tianqitixing.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lbx.tianqitixing.TianqitixingApplication;
import com.lbx.tianqitixing.util.Dxutil;
import com.lbx.tianqitixing.util.SendUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest(classes =TianqitixingApplication.class)
@RunWith(SpringRunner.class)
public class Test1 {
    @Test
    public void m() throws Exception {
        String fz = (String) SendUtil.doGet("http://t.weather.sojson.com/api/weather/city/101230103");
        String py =(String) SendUtil.doGet("http://t.weather.sojson.com/api/weather/city/101181607");
               //平舆 101181607
        System.out.println(py);
        JSONObject jsonObject = JSON.parseObject(py);
        Object o = jsonObject.get("cityInfo");
        JSONObject o1 = (JSONObject)jsonObject.get("data");
        JSONArray json= (JSONArray)o1.get("forecast");
        Map<String,String> map = (Map)o;
        Map<String,String> map1 = (Map)json.getJSONObject(0);
        String message="【小熙机器人】张大妞同学，小博熙提醒你，今天"+map.get("parent")+map.get("city")+","+
                map1.get("high")+map1.get("low")+","+"风速："+map1.get("fl")+map1.get("type")+","+map1.get("notice");
        String message1="【小熙机器人】亲爱的老妈，儿子提醒您，今天"+map.get("parent")+map.get("city")+","+
                map1.get("high")+map1.get("low")+","+"风速："+map1.get("fl")+map1.get("type")+","+map1.get("notice");
        System.out.println(message);
        Dxutil.send(message1,"15516682619");

    }
}
