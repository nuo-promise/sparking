package cn.sparking.bootstrap.controller.emsongeomagnetic;

import cn.sparking.bootstrap.result.emsongeomagnetic.EmsonGeomagneticResponse;
import cn.sparking.bootstrap.services.emsongeomagnetic.EmsonGeomagneticService;
import cn.sparking.core.pattern.AdaptedService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/EmsonGeomagnetic")
public class EmsonGeomagneticController {

    private final EmsonGeomagneticService emsonGeomagneticService;

    public EmsonGeomagneticController(final EmsonGeomagneticService emsonGeomagneticService) {
        this.emsonGeomagneticService = emsonGeomagneticService;
    }

    /**
     * process api.
     * @param jsonObject request params
     * @return {@link EmsonGeomagneticResponse}
     */
    @PostMapping(value = "/api")
    public EmsonGeomagneticResponse processApi(@RequestBody final JSONObject jsonObject) {
        return emsonGeomagneticService.processApi(jsonObject);
    }
}
