package ru.simakov.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "fraud-service")
public interface FraudClient {
    @GetMapping("/api/v1/fraud-check")
    FraudCheckResponse getIsFraudster(@RequestHeader("customerId") long customerId);
}
