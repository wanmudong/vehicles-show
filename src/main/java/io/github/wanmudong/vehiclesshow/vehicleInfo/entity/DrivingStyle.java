package io.github.wanmudong.vehiclesshow.vehicleInfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/13 8:48
 * @description：四、驾驶风格
 * @modified By：
 * @version: $
 */
@Data
public class DrivingStyle {
    private Map totalNums;

    private StyleDistribution styleDistribution;

    //故障车辆列表
    private List faultVehicleList;

    public static DrivingStyle getRandom(List list){
        DrivingStyle drivingStyle = new DrivingStyle();

        Map<String,Integer> map = new HashMap<>();
        map.put("impulse",2000);
        map.put("smooth",3000);
        map.put("general",5000);

        drivingStyle.setStyleDistribution(StyleDistribution.getRandom(12000));
        drivingStyle.setTotalNums(map);
        drivingStyle.setFaultVehicleList(list);

        return drivingStyle;
    }

    public static DrivingStyle getRandomOfProvince(int totalNum){
        DrivingStyle drivingStyle = new DrivingStyle();

        Map<String,Integer> map = new HashMap<>();
        map.put("impulse",2000);
        map.put("smooth",3000);
        map.put("general",5000);

        drivingStyle.setStyleDistribution(StyleDistribution.getRandom(totalNum));
        drivingStyle.setTotalNums(map);

        return drivingStyle;
    }

}
/**
 * 故障分布
 */
@Data
class StyleDistribution{
    private Map<Integer,Map> styleMap;
    @JsonIgnore
    private static final int VEHICLE_MODELS_NUM = 3;
    @JsonIgnore
    private static final int DRIVING_STYLE_NUM = 3;

    public static StyleDistribution getRandom(int totalNum){
        StyleDistribution styleDistribution = new StyleDistribution();
        Map<Integer,Map> styleVehicleMap = new HashMap<>(16);
        Random random = new Random();
        for (int i = 0; i < VEHICLE_MODELS_NUM; i++) {
            if (i == 0){

                Map<String,Double> styleMap = new HashMap<>(16);
                double impulse = (1+random.nextInt(2))/10.0;
                double smooth = impulse+random.nextInt(4)/10.0;
                double general = 1-impulse-smooth;
                styleMap.put("impulse",Math.floor(totalNum*impulse));
                styleMap.put("smooth",Math.floor(totalNum*smooth));
                styleMap.put("general",Math.floor(totalNum*general));
                styleVehicleMap.put(i,styleMap);
              }else {
                Map<String,Integer> styleMap = new HashMap<>(16);

                styleMap.put("impulse",0);
                styleMap.put("smooth",0);
                styleMap.put("general",0);
                styleVehicleMap.put(i,styleMap);
            }

        }
        styleDistribution.setStyleMap(styleVehicleMap);
        return styleDistribution;
    }
}
//@Data
//class TotalNums{
//    private
//}
