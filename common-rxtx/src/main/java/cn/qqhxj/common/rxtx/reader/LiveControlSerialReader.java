package cn.qqhxj.common.rxtx.reader;

import cn.qqhxj.common.rxtx.SerialContext;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author han xinjian
 * @date 2018-12-08 17:20
 **/
public class LiveControlSerialReader implements SerialReader {

    private byte[] startChat;

    private int flagIndex;

    private int dataLengthIndex;

    private int allLength = 0;

    private int length;

    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    private boolean notOver = false;

    public LiveControlSerialReader(int flagIndex, int dataLengthIndex, byte... startChat) {
        this.startChat = startChat;
        this.flagIndex = flagIndex;
        this.dataLengthIndex = dataLengthIndex;
    }

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
        try {
            byte read = ((byte) SerialContext.getSerialPort().getInputStream().read());
            int index = Arrays.binarySearch(startChat, read);
            if (index >= 0) {
                byteBuffer.put((byte) read);
                allLength = 1;
                notOver = true;
            } else {
                if (notOver) {
                    if (allLength == dataLengthIndex) {
                        length = read;
                    }
                    allLength += 1;
                    byteBuffer.put((byte) read);
                    if (allLength == flagIndex + length) {
                        notOver = false;
                        byte[] array = Arrays.copyOf(byteBuffer.array(), byteBuffer.position());
                        byteBuffer = ByteBuffer.allocate(1024);
                        allLength = 0;
                        return array;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}