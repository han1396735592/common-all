package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 颜色传感器
 *
 * @author han xinjian
 * @date 2018-12-20 21:54
 **/
@Data
@NoArgsConstructor
public class ColorSensor extends Sensor {

    protected Integer r;

    protected Integer g;

    protected Integer b;

    public ColorSensor(byte[] bytes) {
        super(bytes);
        r = ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH]);
        g = ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 1]);
        b = ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 2]);
    }
}
