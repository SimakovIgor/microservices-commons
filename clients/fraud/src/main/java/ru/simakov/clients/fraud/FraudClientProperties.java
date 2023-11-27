package ru.simakov.clients.fraud;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties("microservices.clients.fraud")
public class FraudClientProperties {
    private String url;
}
