package cn.qqhxj.common.wsn.sensor;

import cn.qqhxj.common.wsn.SensorDataInfo;
import cn.qqhxj.common.wsn.SensorType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Hex;

import java.util.Arrays;

/**
 * @author han xinjian
 * @date 2018-12-08 19:08
 **/
@Data
@NoArgsConstructor
public abstract class Sensor {

    protected String sensorType;

    protected String ieeeAddress = "";

    protected String parentAddress = "";

    protected String address = "";

    public Sensor(byte[] bytes) {
        char type = (char) bytes[SensorDataInfo.FLAG_INDEX];
        sensorType = SensorType.valueOf(type + "").name;
        try {
            byte[] bytes1 = Arrays.copyOfRange(bytes, SensorDataInfo.PARENT_ADDRESS_START_INDEX, SensorDataInfo.PARENT_ADDRESS_LENGTH + SensorDataInfo.PARENT_ADDRESS_START_INDEX);
            parentAddress = Hex.encodeHexString(bytes1).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            byte[] bytes1 = Arrays.copyOfRange(bytes,
                    SensorDataInfo.ADDRESS_START_INDEX,
                    SensorDataInfo.ADDRESS_START_INDEX + SensorDataInfo.ADDRESS_LENGTH);
            address = Hex.encodeHexString(bytes1).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            byte[] bytes1 = Arrays.copyOfRange(bytes,
                    bytes.length - SensorDataInfo.IEEE_ADDRESS_LENGTH,
                    bytes.length);
            ieeeAddress = Hex.encodeHexString(bytes1).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
