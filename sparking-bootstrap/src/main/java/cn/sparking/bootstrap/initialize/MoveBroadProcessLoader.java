package cn.sparking.bootstrap.initialize;

import cn.sparking.core.configuration.properties.SparkingLockProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

@Component
@ConditionalOnProperty(prefix = "spk.lock.move-broad", name = "active", havingValue = "true", matchIfMissing = true)
public class MoveBroadProcessLoader implements InstantiationAwareBeanPostProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(MoveBroadProcessLoader.class);

    @Resource
    private SparkingLockProperties sparkingLockProperties;

    @Override
    public Object postProcessAfterInitialization(@NonNull final Object bean, final String beanName) throws BeansException {
        if ((bean instanceof SparkingLockProperties) && sparkingLockProperties.getActive()) {
            this.init((SparkingLockProperties) bean);
        }
        return bean;
    }

    protected void init(final SparkingLockProperties properties) {
        try {
            //登录目博请求秘钥
            LOG.info("request movebroad secret!");
        } catch (Exception ex) {
            Arrays.stream(ex.getStackTrace()).forEach(item -> LOG.error(item.toString()));
        }
    }
}
