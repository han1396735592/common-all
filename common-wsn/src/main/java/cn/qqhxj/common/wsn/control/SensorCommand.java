package cn.qqhxj.common.wsn.control;

import cn.qqhxj.common.rxtx.SerialSendDataEntity;

/**
 * @author han xinjian
 * @date 2018-12-22 10:17
 **/
public abstract class SensorCommand implements SerialSendDataEntity {
    protected abstract byte[] command();

    @Override
    public byte[] getBytes() {
        return command();
    }
}
