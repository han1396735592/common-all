package cn.qqhxj.common.web;

import lombok.Data;

/**
 * @author han xinjian
 * @date 2018-11-17 22:52
 **/
@Data
public class WebCodeMsgResult<T> extends WebSesult<T> {
    private Integer code;
    private String msg;
}