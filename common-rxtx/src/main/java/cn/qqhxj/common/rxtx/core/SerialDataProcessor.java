package cn.qqhxj.common.rxtx.core;

/**
 * @author han xinjian
 * @date 2018-12-11 12:50
 **/
@FunctionalInterface
public interface SerialDataProcessor<T> {
    void processor(T t);
}
