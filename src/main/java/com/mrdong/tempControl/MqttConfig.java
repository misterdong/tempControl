package com.mrdong.tempControl;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.mqtt")
@Setter
@Getter
public class MqttConfig {

    @Autowired
    private MqttPushClient mqttPushClient;

    private String username;
    private String password;
    private String hostUrl;
    private String clientId;
    private String defaultTopic;
    private int timeout;
    private int keepalive;

    @Bean
    public MqttPushClient getMqttPushClient(){
        mqttPushClient.connect(hostUrl,clientId,username,password,timeout,keepalive);
        mqttPushClient.subscribe("testtopic/#",0);
        return mqttPushClient;
    }
}
