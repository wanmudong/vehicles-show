package io.github.wanmudong.vehiclesshow.common.domain;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * 车辆总数变化
 * @author wanmudong
 * @date 17:53 2019/4/30
 */
@Data
public class CurrentOnlineVehicle {
    private Map<Integer,Integer> vehicleMap;

    public static CurrentOnlineVehicle getRandom(StatisticsTotal st){
        int onlineVehicleNum = st.getOnlineTotalNum();
        Random random = new Random();
        CurrentOnlineVehicle cv = new CurrentOnlineVehicle();

        Map<Integer,Integer> map = new LinkedHashMap<>();

        for (int i = 1; i < 24; i++) {
            int symbol = random.nextInt(2);
            int currentVehicleNum = symbol==1?
                    onlineVehicleNum+random.nextInt(2000)
                    :onlineVehicleNum-random.nextInt(2000);
            map.put(i,currentVehicleNum);
        }
        map.put(24,onlineVehicleNum);

        cv.setVehicleMap(map);
        return cv;
    }
}
