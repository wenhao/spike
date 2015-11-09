package com.github.wenhao.quartz.job;

import static java.time.LocalTime.now;

import java.util.Arrays;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.wenhao.quartz.service.ScheduleService;

public class OrderJob implements Job {

    public static final String ORDER_ID = "orderId";
    public static final String RANGE = "range";
    public List<Integer> ranges = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        String orderId = context.getMergedJobDataMap().getString(ORDER_ID);
        String range = context.getMergedJobDataMap().getString(RANGE);
        int rangeIndex = ranges.indexOf(Integer.valueOf(range));
        if (rangeIndex != ranges.size() - 1) {
            scheduleService.scheduleJob(ranges.get(rangeIndex + 1), orderId);
        }
        System.out.println("After 5 seconds: " + now().toString() + ": " + orderId);
    }
}
