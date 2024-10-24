package ru.simakov.starter.testing.initializer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = PostgreSQLInitializer.class)
@ActiveProfiles("test")
@ContextConfiguration(initializers = PostgreSQLInitializer.class)
@Slf4j
@SuppressWarnings({"AbbreviationAsWordInName", "PMD.UseExplicitTypes"})
class PostgreSQLInitializerTest {
    @Autowired
    private ApplicationContext context;

    @Test
    void shouldInitializeDatasourceProps() {
        final var environment = context.getEnvironment();

        assertThat(environment)
            .isNotNull();
        assertThat(environment.getRequiredProperty("spring.datasource.url"))
            .isNotBlank()
            .startsWith("jdbc:postgresql:")
            .contains("prepareThreshold=0");
        assertThat(environment.getRequiredProperty("spring.datasource.username"))
            .isNotBlank();
        assertThat(environment.getRequiredProperty("spring.datasource.password"))
            .isNotBlank();
        assertThat(environment.getProperty("spring.jpa.properties.hibernate.enable_lazy_load_no_trans"))
            .isNull();

        log.info("JDBC environment:");
        log.info("spring.datasource.url: " + environment.getRequiredProperty("spring.datasource.url"));
        log.info("spring.datasource.username: " + environment.getRequiredProperty("spring.datasource.username"));
        log.info("spring.datasource.password: " + environment.getRequiredProperty("spring.datasource.password"));

    }

}
