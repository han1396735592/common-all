package cn.qqhxj.common.wsn.parse;

import cn.qqhxj.common.rxtx.core.SerialDataParser;
import cn.qqhxj.common.wsn.sensor.Sensor;

/**
 * @author han xinjian
 * @date 2018-12-08 19:09
 **/
@FunctionalInterface
public interface ISensorDataParse extends SerialDataParser<Sensor> {

}
