package com.loan.customer.customernotificationservice.controller;

import com.loan.validation.loanvalidationservice.model.Customer;
import com.loan.validation.loanvalidationservice.model.Message;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/customer/")
public class CustomerNotificationController {

    @PostMapping(path = "/send-notification",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Message customerNotification(@RequestBody Message message) {
        System.out.println(message);
        return new Message("Message sent to customer");
    }
    
}