package ru.simakov.clients.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import ru.simakov.commons.model.internal.fraud.FraudCheckResponse;

@RequiredArgsConstructor
public class FraudWebClient {

    private final WebClient webClient;

    public FraudCheckResponse checkFraudRisk(final Long customerId) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .pathSegment("api", "v1", "fraud-check")
                .queryParam("customerId", customerId)
                .build())
            .retrieve()
            .bodyToMono(FraudCheckResponse.class)
            .block();
    }

}
