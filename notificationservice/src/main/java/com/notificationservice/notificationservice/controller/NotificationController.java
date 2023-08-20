package com.NotificationService.controller;

import com.NotificationService.dto.CalculateEmi;
import com.NotificationService.dto.NotificationRequest;
import com.NotificationService.dto.NotificationResponce;
import com.NotificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    public NotificationService notificationService;
    @PostMapping("/success")
    public NotificationResponce successNotification(@RequestBody NotificationRequest notificationRequest){

        return notificationService.makeNotification(notificationRequest);
    }
}
