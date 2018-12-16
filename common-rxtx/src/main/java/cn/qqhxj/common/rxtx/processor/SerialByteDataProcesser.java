package cn.qqhxj.common.rxtx.processor;

/**
 * @author han xinjian
 * @date 2018-12-16 10:36
 **/
@FunctionalInterface
public interface SerialByteDataProcesser {

    /**
     * 处理接收的元字节数据
     *
     * @param bytes
     */
    void processer(byte[] bytes);
}
