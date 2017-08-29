package vip.devkit.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 作者 by K
 * 时间：on 2017/1/12 10:47
 * 邮箱 by vip@devkit.vip
 * <p/>
 * 类用途：时间工具
 * 最后修改：
 */
public class DateUtil {
    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT2 = "yyyyMMdd HH:mm:ss";

    /**
     * 将时间字符串转换成Date
     *
     * @param str
     * @param format
     * @return
     */
    public static Date str2Date(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }

    public static Date str2Date(String str) {
        return str2Date(str, null);
    }

    /**
     * 将时间字符串转换成Calendar
     *
     * @param str
     * @param format
     * @return
     */
    public static Calendar str2Calendar(String str, String format) {

        Date date = str2Date(str, format);
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;

    }

    public static Calendar str2Calendar(String str) {
        return str2Calendar(str, null);

    }

    public static String date2Str(Calendar c) {// yyyy-MM-dd HH:mm:ss
        return date2Str(c, null);
    }

    public static String date2Str(Date d) {// yyyy-MM-dd HH:mm:ss
        return date2Str(d, null);
    }

    public static String date2Str(Calendar c, String format) {
        if (c == null) {
            return null;
        }
        return date2Str(c.getTime(), format);
    }


    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param d
     * @param format
     * @return
     */
    public static String date2Str(Date d, String format) {// yyyy-MM-dd HH:mm:ss
        if (d == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(d);
        return s;
    }

    /**
     * yyyyMMdd HH:mm:ss
     *
     * @param d
     * @return
     */
    public static String date2Str2(Date d) {// yyyy-MM-dd HH:mm:ss
        if (d == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT2);
        String s = sdf.format(d);
        return s;
    }


    /**
     * 获得当前日期的字符串格式
     * 2016-05-01
     *
     * @return
     */
    public static String getCurDateStr() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-"
                + c.get(Calendar.DAY_OF_MONTH) + "-"
                + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE)
                + ":" + c.get(Calendar.SECOND);
    }

    /**
     * 获得当前日期的字符串格式
     *
     * @param format
     * @return
     */
    public static String getCurDateStr(String format) {
        Calendar c = Calendar.getInstance();
        return date2Str(c, format);
    }

    /**
     * 获得当前日期的字符串格式,格式到秒
     *
     * @param time
     * @return time -> yyyy-MM-dd-HH-mm-ss
     */
    public static String getMillon(long time) {

        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(time);

    }

    /**
     * 格式到天
     *
     * @param time
     * @return time -> yyyy-MM-dd
     */
    public static String getDay(long time) {

        return new SimpleDateFormat("yyyy-MM-dd").format(time);

    }

    /**
     * 格式到毫秒
     *
     * @param time
     * @return time -> yyyy-MM-dd-HH-mm-ss-SSS
     */
    public static String getSMillon(long time) {

        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS").format(time);

    }


    /**
     * 输入的是String，格式诸如20120102，实现加一天的功能，返回的格式为String，诸如20120103
     *
     * @param str
     * @return
     * @throws ParseException
     */
    public static String strAddOneDay(String str) throws ParseException {
        String year = str.substring(0, 4);
        String month = str.substring(4, 6);
        String day = str.substring(6);
        String date1 = year + "-" + month + "-" + day;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(date1);
        Calendar cd = Calendar.getInstance();
        cd.setTime(startDate);
        cd.add(Calendar.DATE, 1);
        String dateStr = sdf.format(cd.getTime());
        String year1 = dateStr.substring(0, 4);
        String month1 = dateStr.substring(5, 7);
        String day1 = dateStr.substring(8);
        return year1 + month1 + day1;
    }

    /**
     * 输入的是String，格式诸如20120102，实现减一天的功能，返回的格式为String，诸如20120101
     *
     * @param row
     * @return
     * @throws ParseException
     */
    public static String strDecreaseOneDay(String row) throws ParseException {
        String year = row.substring(0, 4);
        String month = row.substring(4, 6);
        String day = row.substring(6);
        String date1 = year + "-" + month + "-" + day;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(date1);
        Calendar cd = Calendar.getInstance();
        cd.setTime(startDate);
        cd.add(Calendar.DATE, -1);
        String dateStr = sdf.format(cd.getTime());
        String year1 = dateStr.substring(0, 4);
        String month1 = dateStr.substring(5, 7);
        String day1 = dateStr.substring(8);
        return year1 + month1 + day1;
    }

    /**
     * 输入的格式为String，诸如20120101，返回的格式为String，诸如2012-01-01
     *
     * @param date
     * @return
     */
    public static String stringDateChange(String date) {
        if (date.length() == "20120101".length()) {
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6);
            return year + "-" + month + "-" + day;
        } else {
            return date;
        }


    }

    /**
     * 获取昨天 Data
     *
     * @param date
     * @return
     */
    public static Date getLastdayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 获取明天Date
     *
     * @param date
     * @return
     */
    public static Date getNextdayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 判断是否是同一天
     *
     * @param one
     * @param another
     * @return
     */
    public static boolean isTheSameDay(Date one, Date another) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(one);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(another);
        int oneDay = calendar.get(Calendar.DAY_OF_YEAR);
        int anotherDay = calendar2.get(Calendar.DAY_OF_YEAR);
        return oneDay == anotherDay;
    }


    /**
     * 获取时间戳
     *
     * @return
     */
    public static long genTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * //yy/1000:相差多少秒  unit=s
     * <p/>
     * //yy/1000/60:相差多少分钟 unit=m
     * <p/>
     * //yy/1000/60/60:相差多少小时  unit=h
     * <p/>
     * //yy/1000/60/60/24:相差多少天  unit=d
     *
     * @param data 时间 yyyyMMdd HH:mm:ss"
     * @param unit s m h d
     * @return 默认返回 d
     */
    public static String getDataCompare(Date data, String unit) {
        if (data == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date    curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
        Date parse = null;
        try {
             parse = formatter.parse("20150608 10:09:18");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long yy = curDate.getTime() - parse.getTime();
        if (unit == null || unit.length() == 0) {
            return String.valueOf(yy/1000/60/60/24);
        } else if (unit.equals("s")) {
            return String.valueOf(yy/1000);
        } else if (unit.equals("m")) {
            return String.valueOf(yy/1000/60);
        } else if (unit.equals("h")) {
            return String.valueOf(yy/1000/60/60);
        } else if (unit.equals("d")) {
            return String.valueOf(yy/1000/60/60/24);
        }
        return String.valueOf(yy/1000/60/60/24);
    }

}
