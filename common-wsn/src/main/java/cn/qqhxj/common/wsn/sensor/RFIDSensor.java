package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author han xinjian
 * @date 2018-12-20 21:58
 **/
@Data
@NoArgsConstructor
public class RFIDSensor extends Sensor {

    protected String cardNumber;

    public RFIDSensor(byte[] bytes) {
        super(bytes);
        cardNumber = "" + bytes[SensorDataInfo.BEGIN_DATA_LENGTH]
                + bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 1]
                + bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 2]
                + bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 3]
                + bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 4]
                + bytes[SensorDataInfo.BEGIN_DATA_LENGTH + 5];
    }
}
