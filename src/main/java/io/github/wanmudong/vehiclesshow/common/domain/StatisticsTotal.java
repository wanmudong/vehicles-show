package io.github.wanmudong.vehiclesshow.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Random;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/25 15:40
 * @description：大屏监控时的各类数据总数
 * @modified By：
 * @version: $
 */
@Data
public class StatisticsTotal {
    ///////////////////////////////
    /**
     * 车辆总数
     */
    private int vehicleTotalNum;
    /**
     * 离线总数
     */
    private int offlineTotalNum;
    /**
     * 在线总数
     */
    private int onlineTotalNum;
    /**
     * 故障总数
     */
    private int malfunctionTotalNum;
    /////////////////////////////////



    public static StatisticsTotal getRandomStatistics(){
        StatisticsTotal st = new StatisticsTotal();
        Random random = new Random();


        Integer vehicleTotalNum = 12000;
        st.setVehicleTotalNum(vehicleTotalNum);
        Integer offlineTotalNum = 900+random.nextInt(100);
        st.setOfflineTotalNum(offlineTotalNum);
        Integer onlineTotalNum = vehicleTotalNum-offlineTotalNum;
        st.setOnlineTotalNum(onlineTotalNum);
        Integer malfunctionTotalNum =  9000+random.nextInt(500);
        st.setMalfunctionTotalNum(malfunctionTotalNum);


        return st;
    }

//    public static void main(String[] args) {
//        System.out.println(getRandomStatistics());
//    }
}
