package com.xiaobai.util;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {
	
	Logger log = Logger.getLogger(KafkaConsumer.class);
	/**
    * 监听test主题,有消息就读取
    * @param message
    */
   @KafkaListener(topics = {"test"})
   public void consumer(String message){
       log.info("test topic message : " + message);
   }
}
