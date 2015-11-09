package com.github.wenhao.quartz.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleApi {

    @RequestMapping(value = "schedule", method = GET)
    public ResponseEntity execute() {
        return ResponseEntity.ok().body("spring quartz");
    }
}
