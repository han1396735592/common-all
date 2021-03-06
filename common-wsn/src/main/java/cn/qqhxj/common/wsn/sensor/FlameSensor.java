package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 火焰传感器
 *
 * @author han xinjian
 * @date 2018-12-19 17:06
 **/
@Data
@NoArgsConstructor
public class FlameSensor extends Sensor {

    protected Boolean normal;

    public FlameSensor(byte[] bytes) {
        super(bytes);
        byte bt = bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 1];
        normal = bt == 0x00;
    }
}
