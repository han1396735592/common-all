package cn.qqhxj.common.rxtx.starter;

import cn.qqhxj.common.rxtx.SerialContext;
import cn.qqhxj.common.rxtx.parse.SerialDataParser;
import cn.qqhxj.common.rxtx.processor.SerialByteDataProcesser;
import cn.qqhxj.common.rxtx.processor.SerialDataProcessor;
import cn.qqhxj.common.rxtx.reader.SerialReader;
import gnu.io.SerialPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author han xinjian
 * @date 2018-12-24 22:48
 **/
@Slf4j
public class SerialContentBuilder implements InitializingBean {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private SerialPortProperties serialPortProperties;

    public void afterPropertiesSet() throws Exception {
        Collection<SerialDataParser> serialDataParsers = applicationContext.getBeansOfType(SerialDataParser.class).values();
        for (SerialDataParser serialDataParser : serialDataParsers) {
            log.debug("配置了 serialDataParser = {}", serialDataParser);
        }
        SerialContext.getSerialDataParserSet().addAll(serialDataParsers);
        Collection<SerialDataProcessor> serialDataProcessors = applicationContext.getBeansOfType(SerialDataProcessor.class).values();
        for (SerialDataProcessor serialDataProcessor : serialDataProcessors) {
            log.debug("配置了 serialDataProcessor = {}", serialDataProcessor);
        }
        SerialContext.getSerialDataProcessorSet().addAll(serialDataProcessors);
        SerialContext.setSerialPort(applicationContext.getBean(SerialPort.class));
        SerialContext.setSerialReader(applicationContext.getBean(SerialReader.class));
        SerialContext.setSerialByteDataProcesser(applicationContext.getBean(SerialByteDataProcesser.class));
    }

}
