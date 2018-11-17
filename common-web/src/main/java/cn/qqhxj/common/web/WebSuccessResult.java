package cn.qqhxj.common.web;

/**
 * @author han xinjian
 * @date 2018-11-17 22:53
 **/
public class WebSuccessResult <T> implements WebSesult<T> {

    private boolean success;

    private T data;

    private WebSuccessResult(){

    }

    public static <T>  WebSuccessResult<T> ok(T data){
        WebSuccessResult<T> result = new WebSuccessResult<T>();
        result.data = data;
        result.success = true;
        return result;
    }

    public static <T> WebSuccessResult<T> err(){
        WebSuccessResult<T> result  =new WebSuccessResult<T>();
        result.success = false;
        return  result;
     }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }
}