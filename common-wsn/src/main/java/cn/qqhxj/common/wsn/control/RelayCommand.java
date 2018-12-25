package cn.qqhxj.common.wsn.control;


import lombok.Setter;

/**
 * 继电器命令
 *
 * @author han xinjian
 * @date 2018-12-22 10:14
 **/
@Setter
public class RelayCommand extends SensorCommand {

    private Boolean open;

    @Override
    protected byte[] command() {
        byte[] command = new byte[3];
        command[0] = ((byte) 0xDD);
        command[1] = ((byte) 0x01);
        command[2] = open ? ((byte) 0xAA) : ((byte) 0xBB);
        return command;
    }
}
