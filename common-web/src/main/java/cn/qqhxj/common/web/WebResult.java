package cn.qqhxj.common.web;

/**
 * @author han xinjian
 * @date 2018-11-17 22:27
 **/
public class WebResult<T> {

    private static final int DEFAULT_ERR_CODE = 500;

    private static final String DEFAULT_ERR_MSG = "服务器未知错误";

    private T data;

    private Integer code = 200;

    private String msg = "ok";

    private WebResult() {
    }

    public static <T> WebResult<T> ok() {
        WebResult<T> result = new WebResult<T>();
        return result;
    }

    public static <T> WebResult<T> ok(T data) {
        WebResult<T> result = new WebResult<T>();
        result.data = data;
        return result;
    }

    public static WebResult err(Integer code, String msg) {
        WebResult<Object> result = new WebResult<Object>();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static WebResult err() {
        WebResult<Object> result = new WebResult<Object>();
        result.code = DEFAULT_ERR_CODE;
        result.msg = DEFAULT_ERR_MSG;
        return result;
    }

    public static WebResult err(String msg) {
        WebResult<Object> result = new WebResult<Object>();
        result.code = DEFAULT_ERR_CODE;
        result.msg = msg;
        return result;
    }

    public static <T> WebResult<T> ok(T data, String msg) {
        WebResult<T> result = new WebResult<T>();
        result.data = data;
        result.msg = msg;
        return result;
    }

    public static WebResult okOrErr(boolean isOk) {
        WebResult<Object> result = new WebResult<Object>();
        if (isOk) {
            result.code = 200;
            result.msg = "ok";
        } else {
            result.code = DEFAULT_ERR_CODE;
            result.msg = DEFAULT_ERR_MSG;
        }
        return result;
    }

    public static WebResult okOrErr(boolean isOk, String errMsg) {
        WebResult<Object> result = new WebResult<Object>();
        if (isOk) {
            result.code = 200;
            result.msg = "ok";
        } else {
            result.code = DEFAULT_ERR_CODE;
            result.msg = errMsg;
        }
        return result;
    }

    public static int getDefaultErrCode() {
        return DEFAULT_ERR_CODE;
    }

    public static String getDefaultErrMsg() {
        return DEFAULT_ERR_MSG;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
