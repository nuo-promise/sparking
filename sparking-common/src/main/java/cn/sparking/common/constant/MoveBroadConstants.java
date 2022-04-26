package cn.sparking.common.constant;

/**
 * MoveBroad Constant.
 */
public class MoveBroadConstants implements Constants {

    public static final String MB_TYPE = "MOVEBROAD";

    public static final String MB_LOCK_FLAG = "MoveBroad";

    public static final String MB_VERSION = "V1.0";

    public static final String MB_CHARACTER = "UTF-8";

    public static final String MOVE_BROAD_ADAPTER_SERVICE = "MoveBroadAdapterService";

    public static final String MB_CMD_LOCK_CONTROL = "LockControl";

    public static final String MB_CMD_SET_LOCK_MODE = "SetLockMode";

    public static final String MB_REQUEST_TMOTEINFO = "TMoteInfo";

    public static final String MB_REQUEST_TMOTESTATUS = "TMoteStatus";

    public static final String MOVE_BROAD_MQ_METHOD_LOCK_STATUS = "LOCK-STATUS";

    public static final String MOVE_BROAD_MQ_METHOD_LOCK_INFO = "LOCK-INFO";

    public static final int MB_LOCK_CONTROL_ACTION_UP = 0;

    public static final int MB_LOCK_CONTROL_ACTION_DOWN = 1;

    public static final int MB_SET_LOCK_MODE_CONTROL = 1;

    public static final int MB_SET_LOCK_MODE_SHARE = 0;

    public static final int MB_ERROR_1010001 = 1010001;

    public static final String MB_ERROR_1010001_MSG = "app_key or access_token is wrong.";

    public static final int MB_ERROR_1010002 = 1010002;

    public static final String MB_ERROR_1010002_MSG = "The application hasn't authorized.";

    public static final int MB_ERROR_1020001 = 1020001;

    public static final String MB_ERROR_1020001_MSG = "The method is not supported.";

    public static final int MB_ERROR_1030001 = 1030001;

    public static final String MB_ERROR_1030001_MSG = "The device is not existed.";

    public static final int MB_ERROR_1050001 = 1050001;

    public static final String MB_ERROR_1050001_MSG = "The input is invalid.";

    public static final int MB_ERROR_100001 = 100001;

    public static final String MB_ERROR_100001_MSG = "Move Broad System Error";
}
