/**
 * @Title: DateUtils.java
 * @Package com.golead.bespoke.util
 * @Description: 日期时间工具类
 * @author chengy
 * @date 2014-6-17 下午03:00:44
 * @version V1.0
 */
package com.golead.art.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

    public static final int YEAR = 0;
    public static final int MONTH = 1;
    public static final int DAY = 2;
    public static final int HOUR = 3;
    public static final int MINUTE = 4;
    public static final int SECOND = 5;
    public static final int LAST_DAY_OF_MONTH = 6;

    private static final String defaultDateFormS = "yyyy-MM-dd";
    private static final String defaultDateFormL = "yyyy-MM-dd HH:mm:ss";
    private static final String defaultDateFormYear = "yyyy";
    private static final String defaultDateFormMonth = "MM";

    private DateUtils() {
    }

    public static String adjustDate(int type, int amount, String date) {
        return adjustDate(date, amountSetter(type, amount));
    }

    public static String adjustDate(int[] type, int[] amount, String date) {
        return adjustDate(date, amountSetter(type, amount));
    }

    /**
     * @param @param  date 需要调整的日期字符串，默认为"yyyy-MM-dd"格式的日期
     * @param @param  amount 变长参数，按照年月日时分秒的顺序，传入要增减的数值
     * @param @return
     * @return String 调整后返回的日期字符串，默认为"yyyy-MM-dd HH:mm:ss"格式的日期
     * @throws
     * @Title: AdjustDate
     * @Description: 日期字符串调整方法
     */
    public static String adjustDate(String date, int... amount) {
        return adjustDate(date, defaultDateFormS, defaultDateFormL, amount);
    }

    public static String adjustDate(int type, int amount, String date, String inputForm, String outputForm) {
        return adjustDate(date, inputForm, outputForm, amountSetter(type, amount));
    }

    public static String adjustDate(int[] type, int[] amount, String date, String inputForm, String outputForm) {
        return adjustDate(date, inputForm, outputForm, amountSetter(type, amount));
    }

    /**
     * @param @param  date 需要调整的日期字符串
     * @param @param  inputForm 需要调整的日期字符串的格式
     * @param @param  outputForm 调整后返回的日期字符串的格式
     * @param @param  amount 变长参数按照年月日时分秒的顺序，传入要增减的数值
     * @param @return
     * @return String
     * @throws
     * @Title: AdjustDate
     * @Description: 日期字符串调整方法
     */
    public static String adjustDate(String date, String inputForm, String outputForm, int... amount) {
        String res = "";

        try {
            SimpleDateFormat sdfIn = new SimpleDateFormat(inputForm);
            SimpleDateFormat sdfOut = new SimpleDateFormat(outputForm);
            res = sdfOut.format(adjustDate(sdfIn.parse(date), amount));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static Date adjustDate(int type, int amount, Date date) {
        return adjustDate(date, amountSetter(type, amount));
    }

    public static Date adjustDate(int[] type, int[] amount, Date date) {
        return adjustDate(date, amountSetter(type, amount));
    }

    /**
     * @param date    需要调整的日期
     * @param amount  变长参数按照年月日时分秒的顺序，传入要增减的数值
     * @param @return
     * @return Date 返回调整后的日期
     * @throws
     * @Title: AdjustDate
     * @Description: 日期调整方法
     */
    public static Date adjustDate(Date date, int... amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        for (int i = 0; i < amount.length; i++) {
            int a = amount[i];
            if (a == 0) continue;

            switch (i) {
                case 0:
                    calendar.add(Calendar.YEAR, a);
                    break;
                case 1:
                    calendar.add(Calendar.MONTH, a);
                    break;
                case 2:
                    calendar.add(Calendar.DATE, a);
                    break;
                case 3:
                    calendar.add(Calendar.HOUR, a);
                    break;
                case 4:
                    calendar.add(Calendar.MINUTE, a);
                    break;
                case 5:
                    calendar.add(Calendar.SECOND, a);
                    break;
                default:
                    break;
            }
        }

        return calendar.getTime();
    }

    private static int[] amountSetter(int type, int amount) {
        return amountSetter(new int[]{type}, new int[]{amount});
    }

    /**
     * @param @param  type 要调整的日期类型，年月日时分秒分别对应常量0~5，该数组中值的顺序要与amount参数中值的顺序相对应
     * @param @param  amount 要增减的数值，该数组中值的顺序要与type参数中值的顺序相对应
     * @param @return
     * @return int[] 返回一个int数组可以做 adjustDate方法的变长参数
     * @throws
     * @Title: amountSetter
     * @Description: adjustDate方法的变长参数设置器
     */
    private static int[] amountSetter(int[] type, int[] amount) {
        int[] array = new int[6];
        for (int i = 0; i < type.length; i++) {
            array[type[i]] = amount[i];
        }
        return array;
    }

    public static Date setDate(int type, int number, Date date) {
        return setDate(date, numberSetter(type, number));
    }

    public static Date setDate(int[] type, int[] number, Date date) {
        return setDate(date, numberSetter(type, number));
    }

    /**
     * @param @param  date 要设置的基础日期
     * @param @param  number 变长参数按照年月日时分秒的顺序，传入要设置的数值
     * @param @return
     * @return Date
     * @throws
     * @Title: setDate
     * @Description: 在基础日期上设置新日期的方法
     */
    public static Date setDate(Date date, Integer... number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        for (int i = 0; i < number.length; i++) {
            Integer n = number[i];
            if (n == null) continue;

            switch (i) {
                case 0:
                    calendar.set(Calendar.YEAR, n);
                    break;
                case 1:
                    calendar.set(Calendar.MONTH, n - 1);
                    break;
                case 2:
                    calendar.set(Calendar.DAY_OF_MONTH, n);
                    break;
                case 3:
                    calendar.set(Calendar.HOUR_OF_DAY, n);
                    break;
                case 4:
                    calendar.set(Calendar.MINUTE, n);
                    break;
                case 5:
                    calendar.set(Calendar.SECOND, n);
                    break;
                case 6:  //将日期设置为指定月份的最后一天
                    if (n > 0) calendar.set(Calendar.MONTH, n - 1);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    int[] type = new int[]{MONTH, DAY};
                    int[] amount = new int[]{1, -1};
                    calendar.setTime(adjustDate(type, amount, calendar.getTime()));
                    break;
                default:
                    break;
            }
        }

        return calendar.getTime();
    }

    private static Integer[] numberSetter(int type, int number) {
        return numberSetter(new int[]{type}, new int[]{number});
    }

    /**
     * @param @param  type 要设置的日期类型，年月日时分秒分别对应常量0~5，该数组中值的顺序要与number参数中值的顺序相对应
     * @param @param  number 要设置的数值，该数组中值的顺序要与type参数中值的顺序相对应
     * @param @return
     * @return Integer[]
     * @throws
     * @Title: numberSetter
     * @Description: setDate方法的变长参数设置器
     */
    private static Integer[] numberSetter(int[] type, int[] number) {
        Integer[] array = new Integer[7];
        for (int i = 0; i < type.length; i++) {
            array[type[i]] = number[i];
        }
        return array;
    }

    /**
     * @param @param  date
     * @param @return
     * @return String
     * @throws
     * @Title: toDateS
     * @Description: 按照“yyyy-MM-dd”的格式将对象转换为日期字符串，对象为null则返回空字符串
     */
    public static String toDateS(Object obj) {
        return toDateStr(obj, defaultDateFormS);
    }

    /**
     * @param @param  date
     * @param @return
     * @return String
     * @throws
     * @Title: toDateL
     * @Description: 按照“yyyy-MM-dd HH:mm:ss”的格式将对象转换为日期字符串，对象为null则返回空字符串
     */
    public static String toDateL(Object obj) {
        return toDateStr(obj, defaultDateFormL);
    }

    /**
     * @param @param  date
     * @param @param  formate
     * @param @return
     * @return String
     * @throws
     * @Title: toDateStr
     * @Description: 按照参数formate的格式将对象转换为日期字符串 ，对象为null则返回空字符串
     */
    public static String toDateStr(Object obj, String formate) {
        return obj == null ? "" : new SimpleDateFormat(formate).format(obj);
    }
    
    public static Date toDate(String dateStr) throws ParseException {
    	return new SimpleDateFormat(defaultDateFormL).parse(dateStr);
    }

    /**
     * @param @return
     * @return String
     * @throws
     * @Title: getTimeStamp
     * @Description: 获取当前日期时间戳。
     */
    public static String getTimeStamp() {
        return getTimeStamp(new Date());
    }

    /**
     * @param @param  date
     * @param @return
     * @return String
     * @throws
     * @Title: getTimeStamp
     * @Description: 获取指定日期时间戳
     */
    public static String getTimeStamp(Date date) {
        return String.valueOf(date.getTime());
    }

    public static String getCurrentYear() {
        return toDateStr(new Date(), defaultDateFormYear);
    }

    public static String getCurrentMonth() {
        return toDateStr(new Date(), defaultDateFormMonth);
    }
    
    public static List<String> listDaysOfMonth(int year, int month, String formate) {
    	List<String> list = new ArrayList<String>();
    	Date startDate = setDate(new int[]{YEAR,MONTH,DAY}, new int[]{year,month,1}, new Date());
    	Date endDate = setDate(LAST_DAY_OF_MONTH, month, startDate);
    	Date date = startDate;
    	while(date.getTime() <= endDate.getTime()) {
    		list.add(toDateStr(date, formate));
    		date = adjustDate(DAY, 1, date);
    	}
    	return list;
    }
}
