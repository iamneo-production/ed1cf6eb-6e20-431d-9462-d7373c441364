package com.emi.loanemiservice.proxy;

import com.emi.emiservice.model.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("customer-service")
public class CustomerNotificationProxy {
    @PostMapping(path = "/send-notification",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Message customerNotification(@RequestBody Message message);
}
