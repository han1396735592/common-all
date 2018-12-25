package cn.qqhxj.common.wsn.parse;


import cn.qqhxj.common.wsn.SensorDataInfo;
import cn.qqhxj.common.wsn.SensorType;
import cn.qqhxj.common.wsn.sensor.*;

/**
 * @author han xinjian
 * @date 2018-12-08 19:13
 **/
public class SensorDataParseImpl implements ISensorDataParse {
    @Override
    public Sensor parse(byte[] bytes) {
        final char type = ((char) bytes[SensorDataInfo.FLAG_INDEX]);
        SensorType sensorType = null;
        try {
            sensorType = SensorType.valueOf(type + "");
        } catch (Exception e) {
            return null;
        }
        Sensor sensor = null;
        switch (sensorType) {
            case A:
                sensor = new RaindropSensor(bytes);
                break;
            case B:
                sensor = new TriaxialAccelerationSensor(bytes);
                break;
            case C:
                sensor = new LightSensor(bytes);
                break;
            case D:
                sensor = new ColorSensor(bytes);
                break;
            case E:
                sensor = new TemperatureAndHumiditySensor(bytes);
                break;
            case F:
                sensor = new AirPressureAltitudeSensor(bytes);
                break;
            case G:
                sensor = new RFIDSensor(bytes);
                break;
            case I:
                sensor = new RemoteControlSensor(bytes);
                break;
            case J:
                sensor = new FlammableGasSensor(bytes);
                break;
            case N:
                sensor = new FlameSensor(bytes);
                break;
            case L:
                sensor = new PhotoSensor(bytes);
                break;
            default:
                sensor = null;
        }
        return sensor;
    }
}
