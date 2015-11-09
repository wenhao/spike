package com.github.wenhao.quartz.service;

import static java.time.LocalTime.now;

import java.util.Arrays;
import java.util.List;

import static org.quartz.DateBuilder.IntervalUnit.SECOND;
import static org.quartz.DateBuilder.futureDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.github.wenhao.quartz.job.OrderJob;

@Service
public class ScheduleService {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    public List<Integer> ranges = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public void pushOrder(String orderId) {
        System.out.println("Schedule now: " + now().toString() + ", order: " + orderId);
        scheduleJob(ranges.get(0), orderId);
    }

    public void scheduleJob(Integer range, String orderId) {
        JobDetail jobDetail = newJob(OrderJob.class)
                .usingJobData(OrderJob.ORDER_ID, orderId)
                .usingJobData(OrderJob.RANGE, range.toString())
                .build();

        Trigger trigger = newTrigger()
                .startAt(futureDate(5, SECOND))
                .build();

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
