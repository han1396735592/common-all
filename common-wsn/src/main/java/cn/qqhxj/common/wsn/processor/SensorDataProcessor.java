package cn.qqhxj.common.wsn.processor;

import cn.qqhxj.common.core.SerialDataProcessor;
import cn.qqhxj.common.wsn.sensor.Sensor;

/**
 * @author han xinjian
 * @date 2018-12-11 11:44
 **/
@FunctionalInterface
public interface SensorDataProcessor<T extends Sensor> extends SerialDataProcessor<T> {

}
