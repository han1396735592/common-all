package cn.qqhxj.common.rxtx.reader;

import cn.qqhxj.common.rxtx.SerialContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author han xinjian
 * @date 2018-12-03 12:58
 **/
public class ConstLengthSerialReader implements SerialReader {

    private int length;

    private int index = 0;

    private byte[] bytes;

    private boolean raed = true;


    @Override
    public String readString() {
        byte[] bytes = readBytes();
        if (bytes != null) {
            if (bytes.length > 0) {
                return new String(bytes);
            }
        }
        return null;
    }

    @Override
    public byte[] readBytes() {
        for (; index < length; index++) {
            try {
                int read = SerialContext.getSerialPort().getInputStream().read();
                if (read == -1) {
                    break;
                } else {
                    bytes[index] = (byte) read;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (index == length) {
            index = 0;
            return bytes;
        }
        return null;
    }

    public ConstLengthSerialReader() {
        length = 24;
        bytes = new byte[length];
    }

    ConstLengthSerialReader(int length) {
        this.length = length;
        bytes = new byte[length];
    }

}
