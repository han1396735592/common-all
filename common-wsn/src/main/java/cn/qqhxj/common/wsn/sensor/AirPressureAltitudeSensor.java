package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 气压海拔传感器
 *
 * @author han xinjian
 * @date 2018-12-22 9:58
 **/
@Data
@NoArgsConstructor
public class AirPressureAltitudeSensor extends Sensor {

    protected Float temperatureValue;

    protected Float airPressureValue;

    public AirPressureAltitudeSensor(byte[] bytes) {
        super(bytes);
        temperatureValue = Float.parseFloat(
                ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH]) + "." + ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 1]));
        airPressureValue = Float.parseFloat(
                ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 2]) + "." + ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 3]));
    }
}
