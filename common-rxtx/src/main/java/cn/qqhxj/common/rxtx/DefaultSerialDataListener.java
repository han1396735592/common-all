package cn.qqhxj.common.rxtx;


import cn.qqhxj.common.rxtx.parse.SerialDataParser;
import cn.qqhxj.common.rxtx.processor.SerialByteDataProcesser;
import cn.qqhxj.common.rxtx.processor.SerialDataProcessor;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * @author han xinjian
 * @date 2018-12-11 12:02
 **/
public class DefaultSerialDataListener implements SerialPortEventListener {
    @Override
    public void serialEvent(SerialPortEvent ev) {
        if (ev.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            Set<SerialDataParser> parserSet = SerialContext.getSerialDataParserSet();
            byte[] bytes = SerialContext.readData();
            Object parse = null;
            for (SerialDataParser serialDataParser : parserSet) {
                parse = serialDataParser.parse(bytes);
                if (parse != null) {
                    dataProcessors(parse);
                }
            }
            if (bytes != null && bytes.length > 0) {
                SerialByteDataProcesser processer = SerialContext.getSerialByteDataProcesser();
                if (processer != null) {
                    processer.processer(bytes);
                }
            }
        } else {
            System.err.println("data parse err or not find parser");
        }
    }

    private void dataProcessors(Object obj) {
        Set<SerialDataProcessor> dataProcessors = SerialContext.getSerialDataProcessorSet();
        for (SerialDataProcessor serialDataProcessor : dataProcessors) {
            Type[] types = null;
            if (serialDataProcessor.getClass().getSuperclass().equals(Object.class)) {
                types = serialDataProcessor.getClass().getGenericInterfaces();
            } else {
                types = serialDataProcessor.getClass().getSuperclass().getGenericInterfaces();
            }
            for (Type type : types) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Type rawType = parameterizedType.getRawType();
                    if (rawType instanceof Class) {
                        boolean equals = rawType.equals(SerialDataProcessor.class);
                        if (equals) {
                            String typeName = ((ParameterizedType) type).getActualTypeArguments()[0].getTypeName();
                            try {
                                Class<?> forName = Class.forName(typeName);
                                if (forName == obj.getClass()) {
                                    serialDataProcessor.processor(obj);
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
