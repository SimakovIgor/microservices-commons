package ru.simakov.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NotificationRequest {
    private Long toCustomerId;
    private String toCustomerEmail;
    private String message;
    private String sender;
}
