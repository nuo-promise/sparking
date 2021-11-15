
package cn.sparking.bootstrap.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Cloud Redis Configuration.
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private String host;

    private int port;

    private String password;

    private int database;

    private int timeout;

    /**
     * Get the value of redis host.
     * @return {@link Integer}
     */
    public String getHost() {
        return host;
    }

    /**
     * Set the redis host.
     * @param host {@link String}
     */
    public void setHost(final String host) {
        this.host = host;
    }

    /**
     * Get the value of redis port.
     * @return {@link Integer}
     */
    public int getPort() {
        return port;
    }

    /**
     * Set the redis port.
     * @param port {@link Integer}
     */
    public void setPort(final int port) {
        this.port = port;
    }

    /**
     * Get the value of redis password.
     * @return {@link Integer}
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the redis password.
     * @param password {@link String}
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Get the value of database.
     * @return {@link Integer}
     */
    public int getDatabase() {
        return database;
    }

    /**
     * Set the redis database.
     * @param database {@link String}
     */
    public void setDatabase(final int database) {
        this.database = database;
    }

    /**
     * Get the value of timeout.
     * @return {@link Integer}
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Set the redis connect timeout.
     * @param timeout {@link Integer}
     */
    public void setTimeout(final int timeout) {
        this.timeout = timeout;
    }
}
