package cn.sparking.bootstrap;
import cn.sparking.bootstrap.configuration.properties.ThreadPoolProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ThreadPoolProperties.class)
public class SparkingBootstrapApplication {
    /**
     * Spring Boot Application.
     * @param args {@link String}
     */
    public static void main(final String[] args) {
        SpringApplication.run(SparkingBootstrapApplication.class, args);
    }
}
