package ru.simakov.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("fraud-service")
public interface FraudClient {

    /**
     * Retrieves the fraud check response for a given customer ID.
     *
     * @param customerId the customer ID for which to perform the fraud check
     * @return the fraud check response containing the result of the check
     */
    @GetMapping("/api/v1/fraud-check")
    FraudCheckResponse getIsFraudster(
        @RequestHeader("customerId") long customerId
    );
}
