package com.hackathon.emicalculatorservice.feignClient;

import com.emiCalculatorService.dto.CalculateEmi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="notification-service",url = "http://localhost:8084/notification")
public interface NotificationFeignClient {
    @PostMapping("/success")
    public String successNotification(@RequestBody CalculateEmi calculateEmi);
}
