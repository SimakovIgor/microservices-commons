package ru.simakov.starter.testing.initializer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {RabbitMQInitializer.class})
@ActiveProfiles("test")
@ContextConfiguration(initializers = {RabbitMQInitializer.class})
class RabbitMQInitializerTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void shouldInitializeDatasourceProps() {
        final var environment = context.getEnvironment();
        assertThat(environment)
            .isNotNull();
        assertThat(environment.getRequiredProperty("spring.rabbitmq.addresses"))
            .isNotBlank()
            .startsWith("amqp:");
        assertThat(environment.getRequiredProperty("spring.rabbitmq.username"))
            .isNotBlank();
        assertThat(environment.getRequiredProperty("spring.rabbitmq.password"))
            .isNotBlank();
    }
}
