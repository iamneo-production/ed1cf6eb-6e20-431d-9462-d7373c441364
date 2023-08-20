package com.hackathon.emicalculatorservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="interest-service",url = "http://localhost:8082/interest")
public interface InterestFeignClient {
    @GetMapping("/rate")
    public double requestRate();
}