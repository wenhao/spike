package com.github.wenhao.quartz.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wenhao.quartz.service.ScheduleService;

@RestController
public class ScheduleApi {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "schedule", method = GET)
    public ResponseEntity execute() {
        scheduleService.pushOrder("f8a7cc00-fe05-4b1c-83ab-3f971a4e406a");
        return ResponseEntity.ok().body("spring quartz");
    }
}
