package cn.sparking.bootstrap.configuration;

import cn.sparking.bootstrap.configuration.properties.RedisLettucePoolProperties;
import cn.sparking.bootstrap.configuration.properties.RedisProperties;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfiguration {

    private final RedisProperties redisProperties;

    private final RedisLettucePoolProperties redisLettucePoolProperties;

    public RedisConfiguration(final RedisProperties redisProperties, final RedisLettucePoolProperties redisLettucePoolProperties) {
        this.redisProperties = redisProperties;
        this.redisLettucePoolProperties = redisLettucePoolProperties;
    }

    /**
     * Key/Value is String Serializer.
     * @return {@link RedisSerializer}
     */
    @Bean(name = "StringRedisSerializer")
    public RedisSerializer<String> redisKeySerializer() {
        return new StringRedisSerializer();
    }

    /**
     * Key/Value is Object Serializer.
     * @return {@link GenericFastJsonRedisSerializer}
     */
    @Bean(name = "GenericFastJsonRedisSerializer")
    public RedisSerializer<Object> redisValueSerializer() {
        return new GenericFastJsonRedisSerializer();
    }

    /**
     * Lettuce Pool Config.
     * @return {@link GenericObjectPoolConfig}
     */
    @Bean(name = "GenericObjectPoolConfig")
    public GenericObjectPoolConfig<Object> genericObjectPoolConfig() {
        GenericObjectPoolConfig<Object> config = new GenericObjectPoolConfig<>();
        config.setMaxIdle(redisLettucePoolProperties.getMaxIdle());
        config.setMinIdle(redisLettucePoolProperties.getMinIdle());
        config.setMaxTotal(redisLettucePoolProperties.getMaxActive());
        config.setMaxWaitMillis(redisLettucePoolProperties.getMaxWait());
        return config;
    }

    /**
     * Redis Lettuce Connection Factory.
     * 参考配置: https://blog.csdn.net/wangh92/article/details/81736820
     * @param config {@link GenericObjectPoolConfig}
     * @return {@link LettuceConnectionFactory}
     */
    @Bean(name = "RedisConnectionFactory")
    public LettuceConnectionFactory lettuceConnectionFactory(@Qualifier(value = "GenericObjectPoolConfig") final GenericObjectPoolConfig<Object> config) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(redisProperties.getDatabase());
        redisStandaloneConfiguration.setHostName(redisProperties.getHost());
        redisStandaloneConfiguration.setPort(redisProperties.getPort());
        redisStandaloneConfiguration.setPassword(redisProperties.getPassword());

        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofMillis(redisProperties.getTimeout()))
                .poolConfig(config)
                .build();

        return new LettuceConnectionFactory(redisStandaloneConfiguration, clientConfiguration);
    }

    /**
     * RedisTemplate.
     * @param connectionFactory connection factory
     * @param redisKeySerializer key serializer
     * @param redisValueSerializer value serializer
     * @return {@link RedisTemplate}
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(@Qualifier(value = "RedisConnectionFactory") final RedisConnectionFactory connectionFactory,
                                                       @Qualifier(value = "StringRedisSerializer") final RedisSerializer<String> redisKeySerializer,
                                                       @Qualifier(value = "GenericFastJsonRedisSerializer") final RedisSerializer<Object> redisValueSerializer) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        // Key serializer
        template.setKeySerializer(redisKeySerializer);
        template.setHashKeySerializer(redisKeySerializer);
       // Value Serializer
        template.setValueSerializer(redisValueSerializer);
        template.setHashValueSerializer(redisValueSerializer);

        template.afterPropertiesSet();
        return template;
    }
}
