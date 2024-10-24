package ru.simakov.starter.testing.initializer;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Set;

@SuppressWarnings("AbbreviationAsWordInName")
public class RabbitMQInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final String VHOST = "test-vhost";
    private static final String USER_NAME = "test-rabbitmq";
    private static final String USER_PASSWORD = "test-rabbitmq-pwd";
    private static final String PERMISSION_ANY = ".*";

    private static final DockerImageName IMAGE = DockerImageName.parse("rabbitmq:management")
        .asCompatibleSubstituteFor("rabbitmq");
    private static final RabbitMQContainer CONTAINER = new RabbitMQContainer(IMAGE)
        .withVhost(VHOST)
        .withUser(USER_NAME, USER_PASSWORD, Set.of("management"))
        .withPermission(VHOST, USER_NAME, PERMISSION_ANY, PERMISSION_ANY, PERMISSION_ANY);

    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        CONTAINER.start();
        TestPropertyValues.of(
            "spring.rabbitmq.addresses=" + CONTAINER.getAmqpUrl() + "/" + VHOST,
            "spring.rabbitmq.username=" + USER_NAME,
            "spring.rabbitmq.password=" + USER_PASSWORD
        ).applyTo(applicationContext.getEnvironment());
    }
}
