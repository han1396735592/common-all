package cn.qqhxj.common.rxtx.processor;

/**
 * @author han xinjian
 * @date 2018-12-11 12:50
 **/
@FunctionalInterface
public interface SerialDataProcessor<T> {
    /**
     * 处理接收到的信息
     *
     * @param t
     */
    void processor(T t);
}
