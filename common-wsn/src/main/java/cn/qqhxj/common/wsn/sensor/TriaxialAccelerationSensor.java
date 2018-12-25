package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 三轴加速度传感器
 *
 * @author han xinjian
 * @date 2018-12-08 19:03
 **/
@Data
@NoArgsConstructor
public class TriaxialAccelerationSensor extends Sensor {

    protected Integer x;

    protected Integer y;

    protected Integer z;

    public TriaxialAccelerationSensor(byte[] bytes) {
        super(bytes);
        x = ((int) bytes[SensorDataInfo.DADA_LENGTH_INDEX]);
        y = ((int) bytes[SensorDataInfo.DADA_LENGTH_INDEX + 1]);
        z = ((int) bytes[SensorDataInfo.DADA_LENGTH_INDEX] + 2);
    }

}
