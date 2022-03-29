package top.ylcao.StdMan.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public static int OPERATION = 0;
    private SimpleDateFormat sdf;
    private Date date;

    public Log() {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        this.sdf = sdf;
        this.date = new Date();// 获取当前时间
    }

    private String getFormatTime() {
        return sdf.format(date);
    }

    public void pLog(int type, String content) {
        System.out.println("[" + getFormatTime() + "]系统操作:" + content);
    }
}
