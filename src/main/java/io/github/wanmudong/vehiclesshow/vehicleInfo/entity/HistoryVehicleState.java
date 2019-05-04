package io.github.wanmudong.vehiclesshow.vehicleInfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.github.wanmudong.vehiclesshow.common.utils.timeUtil.dateTime;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/29 14:41
 * @description：历史车况
 * @modified By：
 * @version: 0.0.1$
 */
@Data
public class HistoryVehicleState {


    /////////////////////////////////
    /**
     * 纵向加速度 -2.3  -  +2.3
     */
    private Map<String,String> verticalAcceleration;
    /**
     * 横向加速度 -2.3  -  +2.3
     */
    private Map<String,String> lateralAcceleration;
    /**
     * 车速 30-70 km/h
     */
    private  Map<String,Integer> speed;
    /**
     * 方向盘转角  -2048  +2047.9
     */
    private  Map<String,String> steeringWheelCorner;

    /////////////////////////////////

    /**
     * 发动机水温  80-90
     */
    private Map<String,Integer>  engineWaterTemperature;
    /**
     * 发动机转速  800-3400
     */
    private Map<String,Integer>  engineSpeed;
    //////////////////////////////////
    /**
     * 胎温  左前 24-50
     */
    private Map<String,Integer> tireTemperatureLeftFront;
    /**
     * 胎压  左前 0-4.5
     */
    private Map<String,Double> tirePressureLeftFront;
    /**
     * 胎温  左后
     */
    private Map<String,Integer> tireTemperatureLeftRear;
    /**
     * 胎压  左后
     */
    private Map<String,Double> tirePressureLeftRear;
    /**
     * 胎温  右前
     */
    private Map<String,Integer> tireTemperatureRightFront;
    /**
     * 胎压  左前
     */
    private Map<String,Double> tirePressureRightFront;
    /**
     * 胎温  右后
     */
    private Map<String,Integer> tireTemperatureRightRear;
    /**
     * 胎压  左前
     */
    private Map<String,Double> tirePressureRightRear;

    @JsonIgnore
    public static final String[]TIME={"08:00","09:00","10:00","11:00",
            "12:00","13:00","14:00",
            "15:00","16:00","17:00",
            "18:00","19:00","20:00",
            "21:00","22:00","23:00",
            "00:00","01:00","02:00",
            "03:00","04:00","05:00",
            "06:00","07:00"};


    public static HistoryVehicleState getRandom(VehicleInfo vehicleInfo){
        HistoryVehicleState historyVehicleState = new HistoryVehicleState();
        Random random = new Random();

        Map<String,String> verticalAccelerationMap = new LinkedHashMap<>(24);
        Map<String,String> lateralAccelerationMap = new LinkedHashMap<>(24);
        Map<String,Integer> speedMap = new LinkedHashMap<>(24);
        Map<String,Integer> engineWaterTemperatureMap = new LinkedHashMap<>(24);
        Map<String,Integer> engineSpeedMap = new LinkedHashMap<>(24);
        Map<String,String> steeringWheelCornerMap = new LinkedHashMap<>(24);
        Map<String,Integer> tireTemperatureLeftFrontMap = new LinkedHashMap<>(24);
        Map<String,Double> tirePressureLeftFrontMap = new LinkedHashMap<>(24);
        Map<String,Integer> tireTemperatureLeftRearMap = new LinkedHashMap<>(24);
        Map<String,Double> tirePressureLeftRearMap = new LinkedHashMap<>(24);
        Map<String,Integer> tireTemperatureRightFrontMap = new LinkedHashMap<>(24);
        Map<String,Double> tirePressureRightFrontMap = new LinkedHashMap<>(24);
        Map<String,Integer> tireTemperatureRightRearMap = new LinkedHashMap<>(24);
        Map<String,Double> tirePressureRightRearMap = new LinkedHashMap<>(24);



        for (int i = 0; i < TIME.length; i++) {
            String symbol = random.nextInt(2) == 1?"+":"-";
            String verticalAcceleration = symbol + random.nextInt(24)/10.0;
            verticalAccelerationMap.put(TIME[i],verticalAcceleration);
            symbol = random.nextInt(2) == 1?"+":"-";
            String lateralAcceleration = symbol + random.nextInt(24)/10.0;
            lateralAccelerationMap.put(TIME[i],lateralAcceleration);
            int speed = 30 + random.nextInt(40);
            speedMap.put(TIME[i],speed);
            symbol = random.nextInt(2) == 1?"+":"-";
            String steeringWheelCorner = symbol + random.nextInt(2047);
            steeringWheelCornerMap.put(TIME[i],steeringWheelCorner);

            int engineSpeed = 800 + random.nextInt(2600);
            engineSpeedMap.put(TIME[i],engineSpeed);
            int engineTemperature = 80 + random.nextInt(10);
            engineWaterTemperatureMap.put(TIME[i],engineTemperature);

            double tirePressure = (random.nextInt(45))/10.0;
            tirePressureLeftFrontMap.put(TIME[i],tirePressure);
            int tireTemperature = 24 + random.nextInt(26);
            tireTemperatureLeftFrontMap.put(TIME[i],tireTemperature);
             tirePressure = (random.nextInt(45))/10.0;
            tirePressureLeftRearMap.put(TIME[i],tirePressure);
             tireTemperature = 24 + random.nextInt(26);
            tireTemperatureLeftRearMap.put(TIME[i],tireTemperature);
            tirePressure = (random.nextInt(45))/10.0;
            tirePressureRightFrontMap.put(TIME[i],tirePressure);
            tireTemperature = 24 + random.nextInt(26);
            tireTemperatureRightFrontMap.put(TIME[i],tireTemperature);
            tirePressure = (random.nextInt(45))/10.0;
            tirePressureRightRearMap.put(TIME[i],tirePressure);
            tireTemperature = 24 + random.nextInt(26);
            tireTemperatureRightRearMap.put(TIME[i],tireTemperature);
        }
        historyVehicleState.setVerticalAcceleration(verticalAccelerationMap);
        historyVehicleState.setLateralAcceleration(lateralAccelerationMap);
        historyVehicleState.setSpeed(speedMap);
        historyVehicleState.setSteeringWheelCorner(steeringWheelCornerMap);
        historyVehicleState.setEngineSpeed(engineSpeedMap);
        historyVehicleState.setEngineWaterTemperature(engineWaterTemperatureMap);
        historyVehicleState.setTirePressureLeftFront(tirePressureLeftFrontMap);
        historyVehicleState.setTireTemperatureLeftFront(tireTemperatureLeftFrontMap);
        historyVehicleState.setTirePressureLeftRear(tirePressureLeftRearMap);
        historyVehicleState.setTireTemperatureLeftRear(tireTemperatureLeftRearMap);
        historyVehicleState.setTirePressureRightFront(tirePressureRightFrontMap);
        historyVehicleState.setTireTemperatureRightFront(tireTemperatureRightFrontMap);
        historyVehicleState.setTirePressureRightRear(tirePressureRightRearMap);
        historyVehicleState.setTireTemperatureRightRear(tireTemperatureRightRearMap);


        return historyVehicleState;

    }

}
