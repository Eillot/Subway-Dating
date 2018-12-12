package com.simon.subwaydating.engine.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain : 日期处理的工具类
 * @contact:
 * @Time : 2018/10/24 16:22
 * @File : DateUtil
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class DateUtil {

    private static Logger log = LoggerFactory.getLogger(DateUtil.class);

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static Map<String, ThreadLocal<SimpleDateFormat>> simpleDateFormatMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    public static String pattern1 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";


    /**
     * Date 转 Long
     * @param date
     * @return long
     */
    public long Date2Long (Date date){

        date = new Date();
        //得到秒数，Date类型的getTime()返回毫秒数
        long result = date.getTime() / 1000;

        return result;
    }

    /**
     *
     * @param minuend 被减数
     * @param subtraction 减数
     * @return long
     */
    public long compareLong(long minuend,long subtraction){

        long comResult = minuend-subtraction;

        return comResult;
    }
    /**
     * 获取当月最后一天
     *
     * @param
     * @return
     */
    public static String getLastDayOfThisMonth() {

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        } catch (Exception ex) {
            log.error("异常：",ex);
            return null;
        }
    }

    public static String getLastDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        // 设置为本月第一天
        calendar.set(Calendar.DATE, 1);
        // 日期减一，上月最后一天
        calendar.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    /**
     * 如果当前日期超过15号，则取最后一天，如果是小于等于15号，则取15号作为最近的还款日
     *
     * @author TomXu
     * @return
     * @since 2012-05-24
     */
    public static String getNearestReturnDate() {

        Calendar calendar = Calendar.getInstance();
        // 取当前日期
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        if (currentDay > 15) {
            return getLastDayOfThisMonth();
        } else {
            calendar.set(Calendar.DATE, 15);
            return new SimpleDateFormat("yyyy-mm-dd").format(calendar.getTime());
        }
    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());

    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static Date getSystemTime() throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentData = df.format(new Date());
        return df.parse(currentData);
    }

    /**
     * 获取特定格式的时间，如格式：yyyyMMddHHmmss
     *
     * @return
     */
    public static String getPatternTime(Date date, String pattern) {
        if (null == date) {
            return "";
        }
        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    /**
     *
     * Description: 根据出生日期求年龄
     *
     * @param
     * @return String
     * @throws ParseException
     * @throws
     * @Author ZYM Create Date: 2013-2-21 上午11:39:38
     */
    public static String getAge(String myDate) throws ParseException {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new Date();
        java.util.Date mydate = myFormatter.parse(myDate);
        // 算出总共多少天
        Long day = ((date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000) + 1);
        // 格式化保留两位小数
        String year = new java.text.DecimalFormat("#.##").format(day / 365f);
        if ("0.00".equals(year)) {
            year = "0.01";
        }
        return year;
    }

    /**
     * 计算时间差
     *
     * @param beginTime
     *            开始时间，格式：yyyy-MM-dd HH:mm:ss
     * @param endTime
     *            结束时间，格式：yyyy-MM-dd HH:mm:ss
     * @return 从开始时间到结束时间之间的时间差（天）
     */
    public static long getTimeDifference(String beginTime, String endTime) {
        long between = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date end = null;
        Date begin = null;
        try {// 将截取到的时间字符串转化为时间格式的字符串
            end = sdf.parse(endTime);
            begin = sdf.parse(beginTime);
        } catch (ParseException e) {
            log.error("异常",e);
        }

        between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
        long day = between / (24 * 3600);
        return day;
    }

    public static long getMinuteDifference(Date date) {
        return getMinuteDifference(date, new Date());
    }

    public static long getMinuteDifference(String dateStr) {
        Date date = parerDateToSec(dateStr);
        return getMinuteDifference(date);
    }

    /**
     * 计算时间差（精度为分钟)
     *
     * @return
     */
    public static long getMinuteDifference(Date beginDate, Date endDate) {
        log.info("calculate minute diff: begin:" + beginDate + ",end:" + endDate);
        long diff = (endDate != null ? endDate.getTime() : 0) - (beginDate != null ? beginDate.getTime() : 0);
        log.debug("diff millseconds:[" + diff + "]");
        long diffMin = diff / DateUtils.MILLIS_PER_MINUTE;
        if (diff % DateUtils.MILLIS_PER_MINUTE > 0) {
            ++diffMin;
        }
        log.info("diff min:[" + diffMin + "]");
        return diffMin;
    }

    /**
     * 计算时间差(精确到分钟)
     *
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    public static long getMinuteDifference(String beginDateStr, String endDateStr) {
        Date begin = parerDateToSec(beginDateStr);
        Date end = parerDateToSec(endDateStr);
        return getMinuteDifference(begin, end);
    }

    public static Date parerDateToSec(String dateStr) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            log.error("异常",e);
        }
        return null;
    }

    public static boolean compareDate(Date date1, Date date2) {
        log.info("compare date, date1:[" + date1 + "] , date2:[" + date2 + "]");
        return getMinuteDifference(date2, date1) > 0 ? true : false;
    }

    public static String getTimeadd(String datetime, int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar now = Calendar.getInstance();
        Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException ex) {
            System.out.println("日期格式不符合要求：" + ex.getMessage());
            return null;
        }
        now.setTime(date);
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH) + n;
        now.set(year, month, day);
        String time = sdf.format(now.getTime());
        return time;

    }

    public static Date parerStringToDate(String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        try {
            d = df.parse(dateStr);
        } catch (ParseException e) {
            log.error("异常",e);
        }
        return d;

    }


    public static Date parerStringToDate(String dateStr, String format) {

        DateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            log.error("异常",e);
        }
        return null;
    }

    public static String parerDateToStr(Date date) {
        return parseDateToStr(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String parseDateToStr(Date date, String formatter) {
        DateFormat df = new SimpleDateFormat(formatter);
        return df.format(date);
    }

    public static boolean compareDatefalse(Date date1, Date date2) {
        log.info("compare date, date1:[" + date1 + "] , date2:[" + date2 + "]");
        return getMinuteDifference(date2, date1) >= 0 ? true : false;
    }

    public static Date getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date time = null;
        try {
            time = sdf.parse(sdf.format(new Date()));

        } catch (ParseException e) {
            log.error("异常",e);
        }
        return time;
    }

    /**
     *
     * Description: 根据传入日期 获得下月还款日期（普通日期月份直接加1即可 特殊日期如1月份28-31号 则以下月最后一天为准）
     *
     * @param loanDate
     *            term 期数
     * @return String
     * @throws
     * @Author hongyeqin Create Date: 2015年1月20日 下午4:42:07
     */
    public static String getReturnDate(String loanDate, int term) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(loanDate);
        } catch (ParseException e) {
            log.error("异常",e);
        }
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, term);
        return sdf.format(calendar.getTime());

    }

    /**
     *
     * Description: 将String转化为日历格式XMLGregorianCalendar
     *
     * @param expectedLoanTime
     * @return XMLGregorianCalendar
     * @throws
     * @Author hongyeqin Create Date: 2015年3月25日 下午2:08:04
     */
    public static XMLGregorianCalendar getXMLGregorianCalendar(String expectedLoanTime) {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(DateUtil.parerDateToSec(expectedLoanTime));
            XMLGregorianCalendar gc = null;
            try {
                gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            } catch (Exception e) {
                log.error("异常",e);
            }
            return gc;
        } catch (Exception e) {
            log.error("异常",e);
        }
        return null;
    }

    /**
     *
     * Description: 将日历格式 转化为String(YYYY-MM-DD)
     *
     * @param
     * @return String
     * @throws
     * @Author hongyeqin Create Date: 2015年3月25日 下午2:08:44
     */
    public static String parseXMLGregorianCalendarToStr(XMLGregorianCalendar xmlGregorianCalendar, String format) {
        return parseDateToStr(xmlGregorianCalendar.toGregorianCalendar().getTime(), format);
    }

    /**
     * @Description:对日期对象进行加减操作
     * @param date
     *            要进行操作日期
     * @param field
     *            Calendar类中的常量
     * @param amount
     *            加减的数值,可以是负数
     * @return
     */
    public static Date operateDate(Date date, int field, int amount) {
        // 创建日历对象
        Calendar c = Calendar.getInstance();
        c.setTime(date); // 赋值时间
        c.add(field, amount); // 操作
        date = c.getTime(); // 将操作后的日期赋值并返回
        return date;

    }

    /**
     * @Description:新增进件的进件日期与指定日期进行比较
     * @param lastIntoTime
     *            新增进件进件日期
     * @param checkDate
     *            指定的比较日期
     * @return 真/假
     * @Author zhiqiangxian
     */
    public static Boolean compareDate(String lastIntoTime, String checkDate) {

        String intoTime = lastIntoTime.substring(0, 10);
        Date intoTimeDate = new Date();
        Date chechDateToDate = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            intoTimeDate = df.parse(intoTime);
            chechDateToDate = df.parse(checkDate);
        } catch (ParseException e) {

            log.error("异常",e);
        }
        // 新增进件进件日期大于等于比较日期返回结果为真
        if (intoTimeDate.getTime() >= chechDateToDate.getTime()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * @Description:计算指定日期当月天数
     * @param date
     *            日期
     * @return dayCount 天数
     * @Author zhiqiangxian
     */
    public static int dateCount(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar myCalendar = Calendar.getInstance(Locale.CHINA);
        try {
            myCalendar.setTime(sdf.parse(date));
        } catch (ParseException e) {
            log.error("异常",e);
        }

        int dayCount = myCalendar.getActualMaximum(Calendar.DATE);
        return dayCount;
    }

    /**
     *
     * Description: 获取当前时间上周的周一
     *
     * @return String
     * @throws
     * @Author hongyeqin Create Date: 2015年10月14日 下午2:06:36
     */
    public static String getLastMonday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset1 = 1 - dayOfWeek;
        calendar.add(Calendar.DATE, offset1 - 7);
        return sdf.format(calendar.getTime());

    }

    /**
     *
     * Description: 获取当前时间上周的周日
     *
     * @param
     * @return String
     * @throws
     * @Author hongyeqin Create Date: 2015年10月14日 下午2:09:13
     */
    public static String getLastSunday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset2 = 7 - dayOfWeek;
        calendar.add(Calendar.DATE, offset2 - 7);
        return sdf.format(calendar.getTime());
    }

    /**
     * add by zhujinjun
     * 返回一个ThreadLocal的SimpleDateFormat
     *
     * @param pattern such as yyyy-MM-dd HH:mm:ss
     * @return
     */
    private static SimpleDateFormat getSimpleDateFormat(final String pattern) {
        ThreadLocal<SimpleDateFormat> threadLocal = simpleDateFormatMap.get(pattern);
        // 双重判断
        if (threadLocal == null) {
            readWriteLock.writeLock().lock();
            threadLocal = simpleDateFormatMap.get(pattern);
            if (threadLocal == null) {
                // 只有simpleDateFormatMap中还没有这个pattern的simpleDate才会生成新的SimpleDateFormat并放入simpleDateFormatMap
                log.info("put new simpleDate of pattern " + pattern + " to simpleDateFormatMap");

                threadLocal = new ThreadLocal<SimpleDateFormat>() {
                    @Override
                    protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat(pattern);
                    }
                };
                simpleDateFormatMap.put(pattern, threadLocal);
            }
            readWriteLock.writeLock().unlock();
        }

        return threadLocal.get();
    }

    /**
     * add by zhujinjun
     * 比较2个时间,这2个时间可以是不一样的格式,但是需要传入pattern
     * @param time1
     * @param time2
     * @param pattern1
     * @param pattern2
     * @return
     * @throws ParseException
     */
    public static boolean isAfter(String time1,String time2,String pattern1,String pattern2) throws ParseException{
        Date date1 = getSimpleDateFormat(pattern1).parse(time1);
        Date date2 = getSimpleDateFormat(pattern2).parse(time2);

        return date1.after(date2);
    }

    /**
     * string 转为 date
     *
     * @description
     * @createDate 2015-5-27 下午07:11:30
     */
    public static Date str2Date(String str) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            log.error("异常",e);
        }
        return date;
    }

    public static String getFormat(String date,String f1,String f2){
        if (StringUtils.isEmpty(date)){
            return "";
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat(f1);
        SimpleDateFormat sdf2 = new SimpleDateFormat(f2);
        try{
            Date d = sdf1.parse(date);
            return sdf2.format(d);
        }catch (Exception e){
            log.info(String.format("date:%s,f1:%s,f2:%s",date,f1,f2));
            log.error("异常",e);
        }
        return "";

    }

    public static String getCurrentDateCh(){
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        return df.format(d);
    }

}
