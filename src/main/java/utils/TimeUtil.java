package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Zhao Qing on 2017/11/15.
 * 自定义时间工具，提供本程序中用到的时间操作
 */
public class TimeUtil {

    /**
     * 获取现在的时间
     * @return  当前系统时间，格式：YYYYMMDD HHMMSS
     */
    public static String nowTime(){
        return new SimpleDateFormat("YYYYMMDD HHMMSS").format(Calendar.getInstance().getTime());
    }
}
