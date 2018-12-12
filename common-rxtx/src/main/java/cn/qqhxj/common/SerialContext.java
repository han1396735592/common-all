package cn.qqhxj.common;

import cn.qqhxj.common.ReaderAndWrite.SerialReader;
import cn.qqhxj.common.core.SerialDataParser;
import cn.qqhxj.common.core.SerialDataProcessor;
import gnu.io.SerialPort;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author han xinjian
 * @date 2018-11-18 23:11
 **/
public class SerialContext {

    private static SerialPort serialPort;

    private static SerialReader serialReader;

    private static Set<SerialDataParser> serialDataParserSet =
            Collections.synchronizedSet(new HashSet<SerialDataParser>());

    public static Set<SerialDataProcessor> serialDataProcessorSet =
            Collections.synchronizedSet(new HashSet<SerialDataProcessor>());

    public static Set<SerialDataProcessor> getSerialDataProcessorSet() {
        return serialDataProcessorSet;
    }

    public static Set<SerialDataParser> getSerialDataParserSet() {
        return serialDataParserSet;
    }

    public static void setSerialReader(SerialReader serialReader) {
        SerialContext.serialReader = serialReader;
    }

    public static void setSerialPort(SerialPort serialPort) {
        SerialContext.serialPort = serialPort;
    }

    public static byte[] readData() {
        return serialReader.readBytes();
    }

    public static boolean sendData(byte[] data) {
        try {
            serialPort.getOutputStream().write(data);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static SerialPort getSerialPort() {
        return serialPort;
    }
}
