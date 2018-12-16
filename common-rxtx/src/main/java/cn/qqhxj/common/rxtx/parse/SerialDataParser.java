package cn.qqhxj.common.rxtx.parse;

/**
 * @author han xinjian
 * @date 2018-12-11 12:07
 **/
@FunctionalInterface
public interface SerialDataParser<T> {
    /**
     * 根据数据转换为对象
     *
     * @param bytes
     * @return
     */
    T parse(byte[] bytes);
}
