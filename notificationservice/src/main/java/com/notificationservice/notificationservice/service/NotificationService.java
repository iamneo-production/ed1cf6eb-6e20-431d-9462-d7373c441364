package com.NotificationService.service;

import com.NotificationService.dto.NotificationRequest;
import com.NotificationService.dto.NotificationResponce;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public NotificationResponce makeNotification(NotificationRequest notificationRequest){

        String status=notificationRequest.getStatus();
        String message="";
        if(status.equals("Success")){
           message = "Success" + " " +
                    "Your Account Number: " + notificationRequest.getAccountNumber() + " " +
                    "Emi Value: " + notificationRequest.getEmivalue();

        } else if (status.equals("Failed")) {
            message = "Failed" + " " +
                    "Your details is not valid: " + "Account Number "+  notificationRequest.getAccountNumber() + " " +
                    "Emi Value: " + 0.0;
        } else if (status.equals("Not Eligible")) {
        message = "Failed" + " " +
                "You is not eligible for loan: " + notificationRequest.getAccountNumber() + " " +
                "Emi Value: " + 0.0;
    }
        else {
            message = "Try again later" + " ";

        }
        NotificationResponce notificationResponce=NotificationResponce.builder()
                .message(message)
                .build();
       return notificationResponce;
    }
}
