package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 雨滴传感器
 *
 * @author han xinjian
 * @date 2018-12-19 17:06
 **/
@Data
@NoArgsConstructor
public class RaindropSensor extends Sensor {

    protected Boolean rainy;

    public RaindropSensor(byte[] bytes) {
        super(bytes);
        rainy = bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 1] == 0x01;
    }
}
