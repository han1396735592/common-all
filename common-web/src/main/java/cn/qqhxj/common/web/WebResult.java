package cn.qqhxj.common.web;

/**
 * @author han xinjian
 * @date 2018-11-17 22:27
 **/
public interface WebResult<T> {

    /**
     *  获取返回的书
     * @return 数据
     */
    T getData();
}
