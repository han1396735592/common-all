package cn.qqhxj.common.web;

/**
 * @author han xinjian
 * @date 2018-11-17 22:52
 **/
public class WebCodeMsgResult<T> implements WebSesult<T> {

    private Integer code;

    private String msg;

    private T data;

    private WebCodeMsgResult() {

    }

    public static <T> WebCodeMsgResult<T> ok(T data) {
        WebCodeMsgResult<T> result = new WebCodeMsgResult<T>();
        result.data = data;
        result.code = 0;
        return result;
    }

    public static <T> WebCodeMsgResult<T> ok(T data, String msg) {
        WebCodeMsgResult<T> result = new WebCodeMsgResult<T>();
        result.data = data;
        result.code = 0;
        result.msg = msg;
        return result;
    }

    public static <T> WebCodeMsgResult<T> err(String msg) {
        WebCodeMsgResult<T> result = new WebCodeMsgResult<T>();
        result.msg = msg;
        result.code = 500;
        return result;
    }

    public static <T> WebCodeMsgResult<T> err(String msg, Integer code) {
        WebCodeMsgResult<T> result = new WebCodeMsgResult<T>();
        result.msg = msg;
        result.code = code;
        return result;
    }

    public T getData() {
        return data;
    }
}