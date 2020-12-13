package com.mrdong.tempControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private MqttPushClient mqttPushClient;

    @GetMapping(value = "/publishTopic/{topic}")
    public RUtils publishTopic(@PathVariable("topic")String topic){
        mqttPushClient.publish(0,false,topic,"测试发布消息");
        return RUtils.ok("发布成功");
    }
}