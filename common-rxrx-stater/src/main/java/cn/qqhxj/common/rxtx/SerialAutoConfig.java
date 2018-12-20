package cn.qqhxj.common.rxtx;

import cn.qqhxj.common.rxtx.parse.SerialDataParser;
import cn.qqhxj.common.rxtx.parse.StringSerialDataParser;
import cn.qqhxj.common.rxtx.processor.SerialDataProcessor;
import cn.qqhxj.common.rxtx.processor.StringSerialDataProcessor;
import cn.qqhxj.common.rxtx.reader.SerialReader;
import cn.qqhxj.common.rxtx.reader.VariableLengthSerialReader;
import gnu.io.SerialPort;
import gnu.io.SerialPortEventListener;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author han xinjian
 * @date 2018-12-16 11:55
 **/
@Component
public class SerialAutoConfig implements InitializingBean {
    @Autowired
    ApplicationContext applicationContext;


    @Autowired
    private SerialPortProperties serialPortProperties;

    @Bean
    @ConditionalOnMissingBean
    public SerialPortEventListener serialPortEventListener() {
        return new DefaultSerialDataListener();
    }

    @Bean
    @ConditionalOnMissingBean
    public SerialPort serialPort(SerialPortEventListener serialPortEventListener) {
        SerialPort serialPort = null;
        try {
            serialPort = SerialUtils.connect(serialPortProperties.getPortName(), serialPortProperties.getBaudRgot());
            serialPort.addEventListener(serialPortEventListener);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serialPort;
    }


    @Bean
    @ConditionalOnMissingBean
    public SerialReader serialReader(SerialPort serialPort) {
        SerialReader serialReader = null;
        try {
            serialReader = new VariableLengthSerialReader(serialPort.getInputStream(), '{', '}');
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serialReader;
    }

    @Bean
    @ConditionalOnMissingBean
    public StringSerialDataParser stringSerialDataParser() {
        return new StringSerialDataParser();
    }

    @Bean
    @ConditionalOnMissingBean
    public StringSerialDataProcessor stringSerialDataProcessor() {
        return new StringSerialDataProcessor();
    }

    public void afterPropertiesSet() throws Exception {
        Map<String, SerialDataParser> beansOfType = applicationContext.getBeansOfType(SerialDataParser.class);
        SerialContext.getSerialDataParserSet().addAll(beansOfType.values());
        Map<String, SerialDataProcessor> beansOfType1 = applicationContext.getBeansOfType(SerialDataProcessor.class);
        SerialContext.getSerialDataProcessorSet().addAll(beansOfType1.values());
        SerialContext.setSerialPort(applicationContext.getBean(SerialPort.class));
        SerialContext.setSerialReader(applicationContext.getBean(SerialReader.class));
    }

}
