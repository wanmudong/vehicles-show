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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatisticsTotal {

    int vehicleTotalNum;
    int offlineTotalNum;
    int onlineTotalNum;
    int malfunctionTotalNum;

    public StatisticsTotal(int vehicleTotalNum, int offlineTotalNum, int onlineTotalNum, int malfunctionTotalNum) {
        this.vehicleTotalNum = vehicleTotalNum;
        this.offlineTotalNum = offlineTotalNum;
        this.onlineTotalNum = onlineTotalNum;
        this.malfunctionTotalNum = malfunctionTotalNum;
    }
    public static StatisticsTotal getRandomStatistics(){
        Random random = new Random();
        Integer vehicleTotalNum = 10052;
        Integer offlineTotalNum = 900+random.nextInt(100);
        Integer onlineTotalNum = vehicleTotalNum-offlineTotalNum;
        Integer malfunctionTotalNum =  40+random.nextInt(20);
        StatisticsTotal st = new StatisticsTotal(vehicleTotalNum,offlineTotalNum,
                onlineTotalNum,malfunctionTotalNum );
        return st;
    }

    public static void main(String[] args) {
        System.out.println(getRandomStatistics());
    }
}
