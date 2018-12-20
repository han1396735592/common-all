package cn.qqhxj.common.rxtx;

import gnu.io.SerialPort;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author han xinjian
 * @date 2018-12-16 11:53
 **/

@Component
@ConfigurationProperties(prefix = "serialport")
public class SerialPortProperties {

    private String portName;

    private int baudRgot;

    private int dataBits = SerialPort.DATABITS_8;

    private int stopBits = SerialPort.STOPBITS_1;

    private int parity = SerialPort.PARITY_NONE;

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public void setBaudRgot(int baudRgot) {
        this.baudRgot = baudRgot;
    }

    public void setDataBits(int dataBits) {
        this.dataBits = dataBits;
    }

    public void setStopBits(int stopBits) {
        this.stopBits = stopBits;
    }

    public void setParity(int parity) {
        this.parity = parity;
    }

    public int getBaudRgot() {
        return baudRgot;
    }

    public int getDataBits() {
        return dataBits;
    }

    public int getStopBits() {
        return stopBits;
    }

    public int getParity() {
        return parity;
    }
}
