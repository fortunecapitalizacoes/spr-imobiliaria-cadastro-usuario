package br.com.tbg.ptg.nominacao.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Value("${info.app.version}")
    private String version;

    @Override
    public Health health() {
        return Health.up().withDetail("version", version).build();
    }
}
