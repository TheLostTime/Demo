package com.example.demo.Service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableAsync
public class SheduleService {
    @Scheduled(fixedRate = 5000)
    @Async("taskExecutor")
    public void task() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("任务1:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date())+"当前线程:"+Thread.currentThread().getName());

    }

    @Scheduled(fixedRate = 5000)
    @Async("taskExecutor")
    public void task2() throws InterruptedException {
        Thread.sleep(100000000);
        System.out.println("任务2;"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date())+"当前线程:"+Thread.currentThread().getName());
    }
}
