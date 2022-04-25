package cn.sparking.core.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spk.lock.move-broad")
public class SparkingLockProperties {
    private Boolean active;

    private String url;

    private String appId;

    private String secret;
}
