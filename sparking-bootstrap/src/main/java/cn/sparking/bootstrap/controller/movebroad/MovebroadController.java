package cn.sparking.bootstrap.controller.movebroad;

import cn.sparking.bootstrap.model.movebroad.LockCallBackRequest;
import cn.sparking.bootstrap.model.movebroad.LockInfoRequest;
import cn.sparking.bootstrap.model.movebroad.LockStatusRequest;
import cn.sparking.bootstrap.services.movebroad.MoveBroadService;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.LockInfo;

@RestController
@RequestMapping(value = "/movebroad")
public class MovebroadController {

    private final MoveBroadService moveBroadService;

    public MovebroadController(final MoveBroadService moveBroadService) {
        this.moveBroadService = moveBroadService;
    }

    /**
     * get lock callback.
     * @param lockCallBackRequest {@link LockCallBackRequest}
     * @return {@link HttpResponseStatus}
     */
    @PostMapping("/lockCallback")
    public HttpResponseStatus moveBroadLockStatus(@RequestBody final LockCallBackRequest lockCallBackRequest) {
        return moveBroadService.lockCallback(lockCallBackRequest);
    }
}
