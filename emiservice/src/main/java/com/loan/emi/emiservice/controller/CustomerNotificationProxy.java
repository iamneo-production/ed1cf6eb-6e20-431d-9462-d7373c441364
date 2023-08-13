package com.loan.emi.emiservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("customer-service")
public interface CustomerNotificationProxy {
    @PostMapping("/customer/send-notification")
    public Message customerNotification(@RequestBody CustomerMessage message);
}
