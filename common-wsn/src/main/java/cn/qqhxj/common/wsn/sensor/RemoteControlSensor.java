package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 遙控器传感器
 *
 * @author han xinjian
 * @date 2018-12-22 10:04
 **/
@Data
@NoArgsConstructor
public class RemoteControlSensor extends Sensor {
    protected Integer keyValue;

    public RemoteControlSensor(byte[] bytes) {
        super(bytes);
        keyValue = ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH]);
    }
}
