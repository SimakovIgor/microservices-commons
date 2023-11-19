package ru.simakov.starter.amqp.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;

@Slf4j
@RequiredArgsConstructor
public class RabbitMQMessageProducer {
    private final AmqpTemplate amqpTemplate;

    /**
     * Publishes a payload to the specified exchange using the given routing key.
     *
     * @param payload    The payload to be published.
     * @param exchange   The exchange to which the payload should be published.
     * @param routingKey The routing key to be used for publishing the payload.
     */
    public void publish(final Object payload,
                        final String exchange,
                        final String routingKey) {
        log.info("Publishing to {} using routing key {}. Payload {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to {} using routing key {}. Payload {}", exchange, routingKey, payload);
    }
}
