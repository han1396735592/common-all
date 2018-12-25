package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 光照传感器
 *
 * @author han xinjian
 * @date 2018-12-20 21:54
 **/
@Data
@NoArgsConstructor
public class LightSensor extends Sensor {

    protected Integer value;

    public LightSensor(byte[] bytes) {
        super(bytes);
        value = ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH]);
    }

}
