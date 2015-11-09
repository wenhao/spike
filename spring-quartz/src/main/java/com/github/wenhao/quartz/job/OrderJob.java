package com.github.wenhao.quartz.job;

import static java.time.LocalTime.now;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

@Service
public class OrderJob implements Job {

    public static final String ORDER_ID = "orderId";

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String orderId = context.getMergedJobDataMap().getString(ORDER_ID);
        System.out.println("After 5 seconds: " + now().toString() + ": " + orderId);
    }
}
