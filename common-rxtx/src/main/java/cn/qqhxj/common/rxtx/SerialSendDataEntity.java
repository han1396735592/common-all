package cn.qqhxj.common.rxtx;

/**
 * @author han xinjian
 * @date 2018-12-16 9:51
 **/
@FunctionalInterface
public interface SerialSendDataEntity {
    /**
     * 数据的反解析接口
     *
     * @return
     */
    byte[] getBytes();
}
