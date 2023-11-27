package ru.simakov.commons.model.internal.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class FraudCheckResponse {
    private Long id;
    private Boolean isFraud;
}
