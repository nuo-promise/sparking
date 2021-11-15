
package cn.sparking.bootstrap.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spk.pool")
public class ThreadPoolProperties {

    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

    /**
     * Get the value of thread pool size.
     * @return {@link Integer}
     */
    public int getCorePoolSize() {
        return corePoolSize;
    }

    /**
     * Set the thread pool size.
     * @param corePoolSize {@link Integer}
     */
    public void setCorePoolSize(final int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    /**
     * Get the value of redis host.
     * @return {@link Integer}
     */
    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    /**
     * Set the thread pool max pool size.
     * @param maxPoolSize {@link Integer}
     */
    public void setMaxPoolSize(final int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    /**
     * Get the value of KeepAliveSeconds.
     * @return {@link Integer}
     */
    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    /**
     * Set the thread pool keep alive seconds.
     * @param keepAliveSeconds {@link Integer}
     */
    public void setKeepAliveSeconds(final int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    /**
     * Get the value of thread pool queueCapacity.
     * @return {@link Integer}
     */
    public int getQueueCapacity() {
        return queueCapacity;
    }

    /**
     * Set the thread pool queue capacity.
     * @param queueCapacity {@link Integer}
     */
    public void setQueueCapacity(final int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
