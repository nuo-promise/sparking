package cn.sparking.bootstrap.services.movebroad;

import cn.sparking.bootstrap.model.movebroad.LockCallBackRequest;
import io.netty.handler.codec.http.HttpResponseStatus;

public interface MoveBroadService {

    /**
     * get lock callback.
     * @param lockCallBackRequest {@link LockCallBackRequest}
     * @return {@link HttpResponseStatus}
     */
    HttpResponseStatus lockCallback(LockCallBackRequest lockCallBackRequest);
}
