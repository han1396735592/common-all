package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 光敏传感器
 *
 * @author han xinjian
 * @date 2018-12-20 16:28
 **/
@Data
@NoArgsConstructor
public class PhotoSensor extends Sensor {

    protected Boolean Light;

    public PhotoSensor(byte[] bytes) {
        super(bytes);
        Light = bytes[SensorDataInfo.BEGIN_DATA_LENGTH] == 0x01;
    }

}
