package ru.simakov.clients.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.simakov.commons.model.internal.fraud.FraudCheckResponse;

@RequiredArgsConstructor
@SuppressWarnings("PMD.UseExplicitTypes")
public class FraudClient {

    private final RestTemplate restTemplate;

    public FraudCheckResponse checkFraudRisk(final Long customerId) {
        final var headers = new HttpHeaders();
        headers.set("customerId", String.valueOf(customerId));

        return restTemplate.exchange("/api/v1/fraud-check", HttpMethod.GET,
                new HttpEntity<>(headers), FraudCheckResponse.class)
            .getBody();
    }
}
