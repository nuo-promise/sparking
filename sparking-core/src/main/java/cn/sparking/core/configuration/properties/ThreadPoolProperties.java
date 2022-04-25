package cn.sparking.core.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spk.pool")
public class ThreadPoolProperties {

    private Integer coreSize;

    private Integer maxSize;

    private Integer keepAlive;

    private Integer queueCapacity;
}
