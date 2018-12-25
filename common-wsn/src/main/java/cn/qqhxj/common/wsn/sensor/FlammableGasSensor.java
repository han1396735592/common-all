package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 可燃气体传感器
 *
 * @author han xinjian
 * @date 2018-12-19 16:59
 **/
@Data
@NoArgsConstructor
public class FlammableGasSensor extends Sensor {

    protected Boolean normal;

    public FlammableGasSensor(byte[] bytes) {
        super(bytes);
        byte bt = bytes[SensorDataInfo.BEGIN_DATA_LENGTH];
        normal = bt != 0x00;
    }

}
