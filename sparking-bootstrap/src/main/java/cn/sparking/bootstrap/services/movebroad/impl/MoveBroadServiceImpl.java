package cn.sparking.bootstrap.services.movebroad.impl;

import cn.sparking.bootstrap.model.movebroad.LockCallBackRequest;
import cn.sparking.bootstrap.services.movebroad.MoveBroadService;
import cn.sparking.common.constant.MoveBroadConstants;
import cn.sparking.core.factory.AdaptedFactory;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("MoveBroadServiceImpl")
public class MoveBroadServiceImpl implements MoveBroadService {

    private static final Logger LOG = LoggerFactory.getLogger(MoveBroadServiceImpl.class);

    private final AdaptedFactory adaptedFactory;

    public MoveBroadServiceImpl(final AdaptedFactory adaptedFactory) {
        this.adaptedFactory = adaptedFactory;
    }

    @Override
    public HttpResponseStatus lockCallback(final LockCallBackRequest lockCallBackRequest) {
        try {
            adaptedFactory.getAdaptedService(MoveBroadConstants.MOVE_BROAD_ADAPTER_SERVICE).adapted(lockCallBackRequest);
        } catch (Exception ex) {
            Arrays.stream(ex.getStackTrace()).forEach(item -> LOG.error(item.toString()));
        }
        return HttpResponseStatus.OK;
    }
}
