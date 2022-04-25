package cn.sparking.bootstrap.model.movebroad;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LockStatusRequest implements Serializable {

    private static final long serialVersionUID = -4424530318391366403L;

    @JSONField(name = "SN")
    private String sn;

    @JSONField(name = "BerthCode")
    private String berthCode;

    @JSONField(name = "Name")
    private String name;

    @JSONField(name = "TMoteStatus")
    private JSONObject tMoteStatus;
}
