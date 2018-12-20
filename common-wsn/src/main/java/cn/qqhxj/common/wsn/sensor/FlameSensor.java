package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;

/**
 * 火焰传感器
 *
 * @author han xinjian
 * @date 2018-12-19 17:06
 **/
public class FlameSensor extends Sensor {

    private Boolean normal;

    public FlameSensor(byte[] bytes) {
        super(bytes);
        byte bt = bytes[SensorDataInfo.DADA_LENGTH_INDEX + 1];
        normal = bt == 0x00;
    }
}
