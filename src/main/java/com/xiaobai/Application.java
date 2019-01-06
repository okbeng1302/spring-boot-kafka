package com.xiaobai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.xiaobai.util.KafkaSender;

@EnableScheduling // 允许定时任务
@SpringBootApplication
@ComponentScan(value = { "com.xiaobai" })
public class Application {
    @Autowired
    private KafkaSender kafkaSender;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // 然后每隔5秒钟执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void testKafka() throws Exception {
        kafkaSender.sendTest();
    }
}
