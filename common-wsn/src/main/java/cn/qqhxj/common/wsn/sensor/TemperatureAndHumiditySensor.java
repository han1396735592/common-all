package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 温湿度传感器
 * @author han xinjian
 * @date 2018-12-08 19:03
 **/
@Data
@NoArgsConstructor
public class TemperatureAndHumiditySensor extends Sensor {

    public TemperatureAndHumiditySensor(byte[] bytes) {
        super(bytes);
        humidityValue = Float.parseFloat(
                ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH]) + "." + ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 1]));
        temperatureValue = Float.parseFloat(
                ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 2]) + "." + ((int) bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 3]));
    }

    protected Float temperatureValue;

    protected Float humidityValue;

}
