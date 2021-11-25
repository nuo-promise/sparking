package cn.sparking.common.utils;

import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveRedisUtils {

    private static final ReactiveRedisTemplate<String, Object> REDISTEMPLATE = SpringBootUtils.getBean("ReactiveRedisTemplate", ReactiveRedisTemplate.class);

    /**
     * putData.
     * @param key the key
     * @param value the value
     * @return {@link Mono}
     */
    public static Mono<Boolean> putValue(final String key, final Object value) {
        ReactiveValueOperations<String, Object> reactiveValueOps = REDISTEMPLATE.opsForValue();
        return reactiveValueOps.set(key, value);
    }

    /**
     * put data and expiry time.
     * @param key the key
     * @param value the value
     * @param time time
     * @return {@link Mono}
     */
    public static Mono<Boolean> putValue(final String key, final Object value, final int time) {
        ReactiveValueOperations<String, Object> reactiveValueOps = REDISTEMPLATE.opsForValue();
        return reactiveValueOps.set(key, value, Duration.ofSeconds(time));
    }

    /**
     * get value by key.
     * @param key the key
     * @return {@link Mono}
     */
    public static Mono<Object> getData(final String key) {
        ReactiveValueOperations<String, Object> reactiveValueOps = REDISTEMPLATE.opsForValue();
        return reactiveValueOps.get(key);
    }
}
