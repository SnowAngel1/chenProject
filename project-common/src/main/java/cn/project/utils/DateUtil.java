
package cn.project.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 日期相关的操作
 */
@Slf4j
public class DateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class.getName());

    // 东八区时区
    public static final String TIMEZONE_GMT8 = "GMT+8";

    //每一天的毫秒数
    private static final long MS_EVERY_DAY = 1000 * 60 * 60 * 24;

    //默认的pattern
    public final static String PATTERN = "yyyyMMdd";

    private final static String PATTERN_ = "yyMMdd";

    public final static String PATTERN_1 = "yyyy/MM/dd";

    public final static String PATTERN_2 = "yyyy/MM/dd HH:mm:ss";

    public final static String PATTERN_3 = "yyyy-MM-dd HH:mm";

    public final static String PATTERN_4 = "yyyy-MM-dd HH:mm:ss";

    private final static String PATTERN_TIME = "yyyy-MM-dd HH:mm:ss.S";

    public final static String PATTERN_TIME2 = "yyyy-MM-dd";

    private final static String PATTERN_TIME3 = "yyyy-MM-dd";

    public final static String TIMESTAMP_PATTERN = "yyyyMMddHHmmss";

    public final static String TIMESTAMP_1 = "yyyyMMddHHmmss";

    public final static String TIMESTAMP_2 = "HHmmss";

    public final static String TIMESTAMP_3 = "HH:mm:ss";

    public final static String TIMESTAMP_4 = "HH:mm";

    /**
     * yyyyMMddHHmmss
     */
    public static final String FULL_DATE_AND_TIME_NO_LINK = "yyyyMMddHHmmss";

    public final static String TIMESTAMP_5 = "yyyyMMddHHmm";
    public final static String FULL_DATE_AND_TIME = "yyyyMMddHHmmssSSS";


    /**
     * 英文简写（默认）如：2010-12
     */
    public static final String FORMAT_SHORT_SHORT = "yyyy-MM";
    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static final String FORMAT_SHORT = "yyyy-MM-dd";
    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    public static final String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */
    public static final String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";
    /**
     * 中文简写 如：2010年12月01日
     */
    public static final String FORMAT_SHORT_CN = "yyyy年MM月dd";
    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    public static final String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";
    /**
     * 精确到毫秒的完整中文时间
     */
    public static final String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    /**
     * 获得默认的 date pattern
     */
    public static String getDatePattern() {
        return FORMAT_LONG;
    }

    /**
     * 获得默认的 date pattern
     */
    public static String getShortDatePattern() {
        return FORMAT_SHORT;
    }

    /**
     * 获得默认的 date pattern
     */
    public static String getShortShortDatePattern() {
        return FORMAT_SHORT_SHORT;
    }

    /**
     * 根据预设格式返回当前日期
     *
     * @return
     */
    public static String getNow() {
        return format(new Date());
    }

    /**
     * 根据用户格式返回当前日期
     *
     * @param format
     * @return
     */
    public static String getNow(String format) {
        return format(new Date(), format);
    }

    /**
     * 使用预设格式格式化日期
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, getDatePattern());
    }


    /**
     * 转换为yyyy-MM-dd格式
     *
     * @param date
     * @return
     */
    public static String formatShort(Date date) {
        return format(date, getShortDatePattern());
    }

    /**
     * 转换为yyyy-MM格式
     *
     * @param date
     * @return
     */
    public static String formatShortShort(Date date) {
        return format(date, getShortShortDatePattern());
    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 使用预设格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @return
     */
    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }


    /**
     * 使用预设格式提取字符串日期 yyyy-MM-dd
     *
     * @param strDate 日期字符串
     * @return
     */
    public static Date parseShort(String strDate) {
        return parse(strDate, getShortDatePattern());
    }


    public static Date parseShortShort(String strDate) {
        return parse(strDate, getShortShortDatePattern());
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 在日期上增加年
     *
     * @param date 日期
     * @param n    要增加的年
     * @return
     */
    public static Date addYear(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    public static Date addDay2(String date1, int n) throws ParseException {

        DateFormat df = new SimpleDateFormat(PATTERN_TIME2);
        String aString = date1.substring(0, 10);
        Date date = df.parse(aString);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n + 1);
        return cal.getTime();
    }

    /**
     * 在日期上增加分钟
     *
     * @param date 日期
     * @param n    要增加的分钟
     * @return
     */
    public static Date addMinute(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加秒
     *
     * @param date 日期
     * @param n    要增加的秒数
     * @return
     */
    public static Date addSecond(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, n);
        return cal.getTime();
    }

    /**
     * 获取时间戳
     */
    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    /**
     * 获取日期年份
     *
     * @param date 日期
     * @return
     */
    public static String getYear(Date date) {
        return format(date).substring(0, 4);
    }

    /**
     * 按默认格式的字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return
     */
    public static int countDays(String date) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return
     */
    public static int countDays(String date, String format) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date, format));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    // 日期格式化
    private static SimpleDateFormat dateFormat;


    static {
        dateFormat = new SimpleDateFormat();
    }

    /**
     *
     */
    public DateUtil() {
        super();
    }

    /*
     *  按自定义格式取得当前日期时间
     *  Sample: DateTimeUtil.getCurrDateTime("yyyyMMddHHmmss")
     */
    public static synchronized String getCurrDateTime(String format) {
        Calendar calendar = GregorianCalendar.getInstance();
        Date date = calendar.getTime();
        dateFormat.applyPattern(format);
        return dateFormat.format(date);
    }

    /**
     * 返回昨天的日期
     *
     * @return
     */
    public static String getYesterdayDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date beginDate = calendar.getTime();
        SimpleDateFormat dateFmt = new SimpleDateFormat(PATTERN);
        String yesterdayDate = dateFmt.format(beginDate);

        return yesterdayDate;
    }

    /**
     * 由日期型转化为"yyyyMMdd"形式的String类型
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {

        SimpleDateFormat dateFmt = new SimpleDateFormat(PATTERN);
        return dateFmt.format(date);
    }

    /**
     * 由日期型转化为"yyyyMMdd"形式的String类型
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date, String pattern) {

        SimpleDateFormat dateFmt = new SimpleDateFormat(pattern);
        return dateFmt.format(date);
    }

    /**
     * 由String类型，转化为日期型
     *
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String strDate) throws ParseException {
        DateFormat df = new SimpleDateFormat(PATTERN);
        Date date = df.parse(strDate);
        return date;
    }

    /**
     * 由String类型，转化为日期型
     *
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate_Time(String strDate) throws ParseException {
        DateFormat df = new SimpleDateFormat(PATTERN_TIME);
        Date date = df.parse(strDate);
        return date;
    }

    /**
     * 由String类型，转化为日期型
     *
     * @param strDate zhs加
     * @return
     * @throws ParseException
     */
    public static Date stringToDate_Time2(String strDate) throws ParseException {
        DateFormat df = new SimpleDateFormat(PATTERN_TIME2);
        Date date = df.parse(strDate);
        return date;
    }

    /**
     * 由String类型，转化为日期型
     *
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringTo_Date_Time2(String strDate) throws ParseException {
        DateFormat df = new SimpleDateFormat(PATTERN_TIME3);
        Date date = df.parse(strDate);
        return date;
    }

    /**
     * 由String类型，转化为日期型
     *
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String strDate, String pattern) throws ParseException {
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = df.parse(strDate);
        return date;
    }

    /**
     * 得到两个日期型数据之间所差的天数,此处为闭区间
     *
     * @param beginDate 起始的日期
     * @param endDate   结束的日期
     * @return 相差的天数
     */
    public static long compare(Date beginDate, Date endDate) {
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();
        long betweenDays = (long) ((endTime - beginTime) / MS_EVERY_DAY);
        if (betweenDays >= 0) {
            return betweenDays + 1;
        } else {
            return betweenDays - 1;
        }

    }

    /**
     * 得到一个日期与当前时间之间所差的天数,此处为闭区间
     *
     * @param beginDate 起始的日期
     * @return 相差的天数
     */
    public static long compare(Date beginDate) {
        long beginTime = beginDate.getTime();
        Calendar calendar = GregorianCalendar.getInstance();
        Date endDate = calendar.getTime();
        long endTime = endDate.getTime();
        long betweenDays = (long) ((endTime - beginTime) / MS_EVERY_DAY);
        return betweenDays;
    }

    /**
     * 取date后第n天的Date
     *
     * @param date
     * @param n
     * @return
     */
    public static Date nextDate(Date date, int n) {
        long day = n * MS_EVERY_DAY;
        Date d = new Date(date.getTime() + day);
        return d;
    }

    /**
     * 检查日期合法性,默认formatType为yyyyMMdd
     *
     * @param date
     * @param
     * @return
     */
    public static boolean checkDate(String date, String formatType) {
        if (null == date) {
            return false;
        }

        if ("".equalsIgnoreCase(formatType) || null == formatType) {
            formatType = "yyyyMMdd";
        }

        try {
            //以SimpleDateFormat來檢核日期
            //關於 SimpleDateFormat 請自己看Java api spec
            SimpleDateFormat dFormat = new SimpleDateFormat(formatType);

            //就是這下面這一行，花了我大半天找問題…
            dFormat.setLenient(false);

            //如果成功就是正確的日期，失敗就是有錯誤的日期。
//    		  java.util.Date d = dFormat.parse(date);
            dFormat.parse(date);

            return true;
        } catch (ParseException e) {
            //告訴user，這個日期不是一個正確的日期"
            return false;
        }
    }

    /**
     * 取得n天时间
     *
     * @param n n=0 今天 n=1 明天；n=0 今天 n=-1 昨天
     * @return String 返回n天时间 yyyy-mm-dd
     */
    public static String getDateList(int n) {

        GregorianCalendar gcDate = new GregorianCalendar();
        String sbDateTodayTime;
        int year = gcDate.get(1);
        int month = gcDate.get(2);
        int date = gcDate.get(5);
        GregorianCalendar oneWeek = new GregorianCalendar(year, month, date);
        oneWeek.add(5, n);
        Date date2 = oneWeek.getTime();
        sbDateTodayTime = dateFormat.format(date2);
        return sbDateTodayTime;
    }

    /**
     * 获取当前时间，返回时间格式(如果调用参数为true时返回yyyy-MM-dd HH:mm:ss
     * ，否则为false时返回yyyy-MM-DD不带日期格式)
     *
     * @param time boolean
     * @return String
     */
    public static String getNowTime(boolean time) {
        Date now = new Date();
        String format = "";
        //yyyy-MM-dd HH:mm:ss:S 年月日时分秒毫杪
        if (time) {
            format = "yyyy-MM-dd ";
        } else {
            format = "yyyy-MM-dd HH:mm:ss.s";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(now);
        return nowtime;
    }


    /**
     * 获取当前时间，返回时间格式yyyyMMdd
     *
     * @return String
     */
    public static String getNowTime() {
        Date now = new Date();
        String format = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(now);
        return nowtime;
    }

    /**
     * 返回6位当前时间 生成报文参考号时使用
     *
     * @return
     */
    public static String getCurrentTime() {
        return parseDate(new Date(), PATTERN_);
    }

    //
    // /**
    // * 返回当前时间 生成报文参考号时使用
    // *
    // * @return
    // */
    // public static String getCurrentTimeForHvps() {
    // return parseDate(new Date());
    // }

    /**
     * @param dateStr 日期字符串
     * @return
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, PATTERN);
    }

    /**
     * @param date
     * @return
     */
    public static String parseDateTimeStamp(Date date) {
        return parseDate(date, TIMESTAMP_PATTERN);
    }

    /**
     * @param dateStr 日期字符串
     * @return
     */
    public static Timestamp parseDateTimeStamp(String dateStr) {
        return new Timestamp(parseDate(dateStr, TIMESTAMP_PATTERN).getTime());
    }

    /**
     * @param dateStr 日期字符串
     * @param pattern 格式化字符串
     * @return
     */
    public static Date parseDate(String dateStr, String pattern) {
        // dateFmt.applyPattern(pattern);
        SimpleDateFormat dateFmt = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFmt.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * @param date 日期
     * @return
     */
    public static String parseDate(Date date) {
        return parseDate(date, PATTERN);
    }

    /**
     * @param date    日期
     * @param pattern 格式化字符串
     * @return
     */
    public static String parseDate(Date date, String pattern) {
        SimpleDateFormat dateFmt = new SimpleDateFormat(pattern);
        return dateFmt.format(date);
    }


    /**
     * 计算某一月份的最大天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getMonthDay(int year, int month) {
        Calendar time = Calendar.getInstance();
        time.clear();//注：在使用set方法之前，必须先clear一下，否则很多信息会继承自系统当前时间
        time.set(Calendar.YEAR, year);
        time.set(Calendar.MONTH, month - 1);//注意,Calendar对象默认一月为0
        int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数
        return day;
    }

    /**
     * 计算两个时间之间相隔天数
     *
     * @param startday 开始时间
     * @param endday   结束时间
     * @return
     */
    @Deprecated
    public static int getIntervalDays(Calendar startday, Calendar endday) {
        //确保startday在endday之前
        if (startday.after(endday)) {
            Calendar cal = startday;
            startday = endday;
            endday = cal;
        }
        //分别得到两个时间的毫秒数
        long sl = startday.getTimeInMillis();
        long el = endday.getTimeInMillis();

        long ei = el - sl;
        //根据毫秒数计算间隔天数
        return (int) (ei / (1000 * 60 * 60 * 24));
    }

    /**
     * 计算两个时间之间相隔天数
     *
     * @param startday 开始时间
     * @param endday   结束时间
     * @return
     */
    public static int getIntervalDays(Date startday, Date endday) {
        //确保startday在endday之前
        if (startday.after(endday)) {
            Date cal = startday;
            startday = endday;
            endday = cal;
        }
        //分别得到两个时间的毫秒数
        long sl = startday.getTime();
        long el = endday.getTime();

        long ei = el - sl;
        //根据毫秒数计算间隔天数
        return (int) (ei / (1000 * 60 * 60 * 24));
    }

    /**
     * 改进精确计算相隔天数的方法
     */
    public static int getDaysBetween(Calendar d1, Calendar d2) {
        if (d1.after(d2)) {  // swap dates so that d1 is start and d2 is end
            Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);//得到当年的实际天数
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    public static int getDaysBetween(Date begin, Date end) {
        Calendar d1 = Calendar.getInstance();
        d1.setTime(begin);

        Calendar d2 = Calendar.getInstance();
        d2.setTime(end);

        if (d1.after(d2)) {  // swap dates so that d1 is start and d2 is end
            Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);//得到当年的实际天数
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * 返回时间间隔的秒数
     *
     * @param endDate
     * @param nowDate
     * @return
     */
    public static int calLastedTime(Date endDate, Date nowDate) {
        long a = endDate.getTime();
        long b = nowDate.getTime();
        int c = (int) ((a - b) / 1000);
        return c;
    }


    public static String timeDifference(String time) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = df.parse(DateUtil.getNow(DateUtil.FORMAT_LONG));
        Date date = df.parse(time);
        long l = now.getTime() - date.getTime();
        return l / 1000 + "";
    }


    public static boolean strictCheckDate(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        df.setLenient(false);
        try {
            df.parse(strDate);
            return true;
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    public static boolean isWeek(Date date) {
        boolean isWeek = false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(7) - 1;
        if (week == 0 || week == 6) {
            isWeek = true;
        }

        return isWeek;
    }

    /**
     * 获取俩个日期字符串之间的日期集合   前包 后包
     *
     * @param begin
     * @param end
     * @param patten
     * @return
     * @throws ParseException
     */
    public static String[] listDate(String begin, String end, String patten) throws ParseException {
        SimpleDateFormat sdf;
        if (!"".equals(patten) && null != patten) {
            sdf = new SimpleDateFormat(patten);
        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        Date bg = sdf.parse(begin);
        Date ed = sdf.parse(end);

        Calendar begc = Calendar.getInstance();
        Calendar endc = Calendar.getInstance();
        begc.setTime(bg);
        endc.setTime(ed);
        int days = getDaysBetween(begc, endc);
        String[] listArs = new String[days + 1];
        for (int i = days; i >= 0; i--) {
            listArs[days - i] = formatDate("", getNextDay(ed, i));
        }
        return listArs;
    }

    public static String formatDate(String format, Date date) {
        SimpleDateFormat sdf;
        if (format == null || "".equals(format)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            sdf = new SimpleDateFormat(format);
        }
        return sdf.format(date);
    }

    public static String getNowTime1() {
        Date now = new Date();
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(now);
        return nowtime;
    }

    public static Date getNextDay(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -i);
        date = calendar.getTime();
        return date;
    }

    public static String dateToStringBeginOrEnd(Date date, Boolean flag) {
        String time = null;
        SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar1 = Calendar.getInstance();
        //获取某一天的0点0分0秒 或者 23点59分59秒
        if (flag == true) {
            calendar1.setTime(date);
            calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
                    0, 0, 0);
            Date beginOfDate = calendar1.getTime();
            time = dateformat1.format(beginOfDate);
            System.out.println(time);
        } else {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            calendar1.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH),
                    23, 59, 59);
            Date endOfDate = calendar1.getTime();
            time = dateformat1.format(endOfDate);
            System.out.println(time);
        }
        return time;
    }

    public static Date dateToBeginOrEnd(Date date, Boolean flag) {
        Calendar calendar1 = Calendar.getInstance();
        //获取某一天的0点0分0秒 或者 23点59分59秒
        if (flag == true) {
            calendar1.setTime(date);
            calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
                    0, 0, 0);
            Date beginOfDate = calendar1.getTime();
            return beginOfDate;
        } else {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            calendar1.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH),
                    23, 59, 59);
            Date endOfDate = calendar1.getTime();
            return endOfDate;
        }
    }

    public static Date dateBeginOrEnd(Date date, Boolean flag) {
        Calendar calendar1 = Calendar.getInstance();
        //获取某一天的0点0分0秒 或者 23点59分59秒
        if (flag) {
            calendar1.setTime(date);
            calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
                    calendar1.get(Calendar.HOUR_OF_DAY), 0, 0);
            return calendar1.getTime();
        } else {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            calendar2.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH),
                    calendar2.get(Calendar.HOUR_OF_DAY), 59, 59);
            return calendar2.getTime();
        }
    }

    /**
     * 解决日期时区问题
     * 转化为北京时间
     *
     * @param timeStr String日期字符串
     * @return 返回Date型
     */
    public static Date trans2LocalDate(String timeStr) {
        if (timeStr == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        String start = timeStr.replace("Z", " UTC");
        try {
            return format.parse(start);
        } catch (ParseException e) {
            LOGGER.error("时间转换方法异常，参数:{}", timeStr, e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取固定日期相隔指定时间差的日期
     * <p>时间差为正数代表指定日期之后，负数代表指定日期之前</p>
     *
     * @param nowDay nowDay
     * @return differ date
     */
    public static Date getDifferenceDate(Date nowDay, int i) {
        Calendar c = Calendar.getInstance();
        // 指定日期为空则赋值为当期日期
        c.setTime(null == nowDay ? new Date() : nowDay);
        // 计算时间差
        c.add(Calendar.DATE, i);
        return c.getTime();
    }

    /**
     * 给时间加上几个小时
     *
     * @param date 当前时间
     * @param hour 需要加的时间
     * @return Date after add
     */
    public static Date addDateMinut(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        return date;
    }

    /**
     * 当前时间距离月底天天数除以本月总天数的值
     *
     * @return
     */
    public static BigDecimal getDayNumToMonthEnd(Date date) {

        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.setTime(date);
        // 本月天数
        BigDecimal monthDay = new BigDecimal(aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 本月第几天
        BigDecimal dayIndex = new BigDecimal(aCalendar.get(Calendar.DAY_OF_MONTH));
        return monthDay.subtract(dayIndex).divide(monthDay, 3, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 获取指定日期当月和下个月的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfNextMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取某年某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return cal.getTime();
    }

    /**
     * 根据自定义格式 获取当前时间
     *
     * @param format
     * @return
     */
    public static String getNowTime(String format) {
        Date date = new Date();
        if (StringUtils.isNotBlank(format)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(date);
            return time;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            String time = dateFormat.format(date);
            return time;
        }

    }

    /**
     * Description: 判断一个时间是否在一个时间段内 </br>
     *
     * @param nowTime   当前时间 </br>
     * @param beginTime 开始时间 </br>
     * @param endTime   结束时间 </br>
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }

    /**
     * 获取一个日期的月初和月末的时间
     * @param date_str  date_str
     * @return Map
     * @throws ParseException gh
     */
    public static Map<String, Date> getFirstAndLastDayOfMonth(String date_str) throws ParseException {
        Map<String, Date> map = new HashMap<>();
        Calendar cale = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        cale.setTime(formatter.parse(date_str));
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        // 当月第一天
        Date firstDayOfMonth = cale.getTime();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        // 当月最后一天
        Date lastDayOfMonth = cale.getTime();
        map.put("first",firstDayOfMonth);
        map.put("last",lastDayOfMonth);
        return map;
    }

}