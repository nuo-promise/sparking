package cn.sparking.bootstrap.services.movebroad;

import cn.sparking.bootstrap.services.emsongeomagnetic.EmsonGeomagneticAdapterService;
import cn.sparking.common.constant.MoveBroadConstants;
import cn.sparking.core.pattern.AdaptedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MoveBroadAdapterService extends AdaptedService {

    private static final Logger LOG = LoggerFactory.getLogger(MoveBroadAdapterService.class);

    /**
     * ACCESS_TOKEN expired time.
     * default one day.
     */
    private static final int REDIS_EXPIRED_INTERVAL = 86400;

    public MoveBroadAdapterService(final String serviceName) {
        super(MoveBroadConstants.MOVE_BROAD_ADAPTER_SERVICE);

    }

    @Override
    public void adapted(final Object parameters) {

    }

    @Override
    public void antiAdapted(final Object parameters) {

    }
}
