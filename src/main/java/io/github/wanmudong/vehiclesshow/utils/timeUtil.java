package io.github.wanmudong.vehiclesshow.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 对对时间进行操作的工具类
 */
public class timeUtil {
    /**
     * 获取精确到秒的时间戳
     * @param
     * @return
     */
    public static int getSecondTimeNow(){

        String timestamp = String.valueOf(new Date().getTime()/1000);
        return Integer.valueOf(timestamp);
    }

    /**
     * 返回时间戳
     * @param date_str
     * @param format
     * @return
     */
    public static String dateTimeStamp(String date_str,String format){

                if (date_str ==null ||date_str.equals("")){
                    return "0";
                 }
               try {
                        SimpleDateFormat sdf = new SimpleDateFormat(format);
                        return String.valueOf(sdf.parse(date_str).getTime()/1000);
                  } catch (Exception e) {
                       e.printStackTrace();
                  }
                 return "0";
         }

    /**
     * 返回格式化后的时间   yyyy-MM-dd     "yyyy-MM-dd HH:mm:ss"
     *

     * @param time
     * @return
     */
    public static String dateTime(long time,String format) {


        if (time ==0){
            return "";
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            //数据库存储的是注册时的时间戳，单位是s
            Date date = new Date(time);
            String time_model = simpleDateFormat.format(date);
            return time_model;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        //数据库存储的是注册时的时间戳，单位是s
//        Date date = new Date(time * 1000);
//        String time_model = simpleDateFormat.format(date);
//        return time_model;
    }

//    public static String dateTime(long time){
//        return  dateTime(time,"yyyy-MM-dd");
//    }
    public static String dateTime(long time){
        return  dateTime(time,"yyyy-MM-dd HH:mm:ss");
    }
}
