package com.emiCalculatorService.feignClient;

import com.emiCalculatorService.dto.CalculateEmi;
import com.emiCalculatorService.dto.NotificationRequest;
import com.emiCalculatorService.dto.NotificationResponce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="notification-service",url = "http://localhost:8084/notification")
public interface NotificationFeignClient {
    @PostMapping("/success")
    public NotificationResponce successNotification(@RequestBody NotificationRequest notificationRequest);
}
