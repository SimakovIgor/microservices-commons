package ru.simakov.clients.fraud;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(FraudClientProperties.class)
public class FraudClientConfiguration {

    @Bean
    public FraudWebClient fraudWebClient(final FraudClientProperties fraudClientProperties) {
        final WebClient webClient = WebClient.builder()
            .baseUrl(fraudClientProperties.getUrl())
            .build();
        return new FraudWebClient(webClient);
    }

    @Bean
    public FraudClient fraudClient(final FraudClientProperties fraudClientProperties) {
        final RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder()
            .rootUri(fraudClientProperties.getUrl());
        return new FraudClient(restTemplateBuilder.build());
    }
}
