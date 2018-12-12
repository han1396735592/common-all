package cn.qqhxj.common.wsn.parse;


import cn.qqhxj.common.wsn.SensorDataInfo;
import cn.qqhxj.common.wsn.SensorType;
import cn.qqhxj.common.wsn.sensor.Sensor;
import cn.qqhxj.common.wsn.sensor.TemperatureAndHumiditySensor;

/**
 * @author han xinjian
 * @date 2018-12-08 19:13
 **/
public class SensorDataParseImpl implements ISensorDataParse {
    @Override
    public Sensor parse(byte[] bytes) {
        final char type = ((char) bytes[SensorDataInfo.FLAG_INDEX]);
        SensorType sensorType = SensorType.valueOf(type + "");
        Sensor sensor = null;
        switch (sensorType) {
            case A:
                break;
            case B:
                break;
            case E:
                sensor = new TemperatureAndHumiditySensor(bytes);
                break;
            default:
                sensor = null;
        }
        return sensor;
    }
}
