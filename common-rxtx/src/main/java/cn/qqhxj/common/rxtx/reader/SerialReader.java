package cn.qqhxj.common.rxtx.reader;

import java.io.InputStream;

/**
 * @author han xinjian
 * @date 2018-12-03 13:01
 **/
public interface SerialReader {

    /**
     * 设置输入流
     *
     * @param inputStream
     */
    void setInputStream(InputStream inputStream);

    /**
     * 读取一个数据
     *
     * @return
     */
    String readString();

    /**
     * 读取byte数组
     *
     * @return
     */
    byte[] readBytes();
}
