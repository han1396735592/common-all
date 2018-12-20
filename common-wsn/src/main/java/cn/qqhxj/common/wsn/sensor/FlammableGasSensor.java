package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;

/**
 * 可燃气体传感器
 *
 * @author han xinjian
 * @date 2018-12-19 16:59
 **/
public class FlammableGasSensor extends Sensor {

    private Boolean normal;

    public FlammableGasSensor(byte[] bytes) {
        super(bytes);
        byte bt = bytes[SensorDataInfo.DADA_LENGTH_INDEX + 1];
        normal = bt != 0x00;
    }

    public Boolean getNormal() {
        return normal;
    }

    public void setNormal(Boolean normal) {
        this.normal = normal;
    }
}
