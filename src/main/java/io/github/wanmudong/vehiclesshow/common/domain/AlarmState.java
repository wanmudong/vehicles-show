package io.github.wanmudong.vehiclesshow.common.domain;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/30 18:10
 * @description：报警情况
 */
@Data
public class AlarmState {

    private Map<Integer,Integer> alarmMap;

    public static AlarmState getRandom(StatisticsTotal st){
        int malfunctionTotalNum = st.getMalfunctionTotalNum()/100;
        Random random = new Random();
        AlarmState as = new AlarmState();

        Map<Integer,Integer> map = new LinkedHashMap<>();

        for (int i = 1; i < 24; i++) {
            int symbol = random.nextInt(2);
            int currentVehicleNum = symbol==1?
                    malfunctionTotalNum+random.nextInt(20)
                    :malfunctionTotalNum-random.nextInt(20);
            map.put(i,currentVehicleNum);
        }
        map.put(24,malfunctionTotalNum);

        as.setAlarmMap(map);
        return as;
    }
}
