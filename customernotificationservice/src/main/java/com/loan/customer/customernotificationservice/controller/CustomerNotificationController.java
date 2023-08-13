package com.loan.customer.customernotificationservice.controller;

import com.loan.customer.customernotificationservice.model.Message;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/customer/")
public class CustomerNotificationController {

    @PostMapping(path = "/send-notification")
    public boolean customerNotification(@RequestBody CustomerMessage customerMessage) {
        System.out.println(customerMessage.getCustomerMessage());        
        return true;
    }
    
}
