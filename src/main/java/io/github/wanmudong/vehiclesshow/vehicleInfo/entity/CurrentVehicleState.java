package io.github.wanmudong.vehiclesshow.vehicleInfo.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static io.github.wanmudong.vehiclesshow.common.utils.timeUtil.dateTime;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/29 14:41
 * @description：当前车况
 * @modified By：
 * @version: 0.0.1$
 */
@Data
public class CurrentVehicleState {
    ///////////////////////////////
    /**
     * 总行驶里程 5000-10000 km
     */
    private int totalMileage;
    /**
     * 总行驶时间 300-450 h
     */
    private int totalTravelTime;
    /**
     * 总油量 总行驶里程的 0.06-0.09 倍
     */
    private  int totalOil;

    /////////////////////////////////
    /**
     * 纵向加速度 -2.3  -  +2.3
     */
    private String verticalAcceleration;
    /**
     * 横向加速度 -2.3  -  +2.3
     */
    private String lateralAcceleration;
    /**
     * 车速 30-70 km/h
     */
    private int speed;

    /////////////////////////////////

    /**
     * 当前油量  随意  百分比
     */
    private int currentOil;

    /////////////////////////////////
    /**
     * 发动机水温  80-90
     */
    private int  engineWaterTemperature;
    /**
     * 发动机转速  800-3400
     */
    private int  engineSpeed;
    /**
     * 胎温  左前 25-27
     */
    private int tireTemperatureLeftFront;
    /**
     * 胎压  左前 2.4-2.6
     */
    private double tirePressureLeftFront;
    /**
     * 胎温  左后
     */
    private int tireTemperatureLeftRear;
    /**
     * 胎压  左前
     */
    private double tirePressureLeftRear;
    /**
     * 胎温  右前
     */
    private int tireTemperatureRightFront;
    /**
     * 胎压  左前
     */
    private double tirePressureRightFront;
    /**
     * 胎温  右后
     */
    private int tireTemperatureRightRear;
    /**
     * 胎压  左前
     */
    private double tirePressureRightRear;

    ///////////////////////////////////
    /**
     * 车辆基本信息  VIN 车型 地区
     */
    private VehicleInfo vehicleInfo;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String altitude;
    /**
     * 最后有效时间 2019/4/24 格式
     */
    private String lastEffectiveTime;
    /**
     * 报警状况 报警或未报警
     */
    private String alarmCondition;
    /**
     * 车辆状况  启动或未启动
     */
    private String vehicleCondition;
    /////////////////////////////////
    /////故障监控  均为正常
    /**
     * 发动机系统
     */
    private String engineSystem;
    /**
     * 制动系统
     */
    private String brakingSystem;
    /**
     * 轮胎系统
     */
    private String tireSystem;
    /**
     * 转速器系统
     */
    private String tachometerSystem;
    /////////////////////////////////
    /**
     * 车速变化分析  一分钟内每隔六秒时间与车速对应关系
     */
    private Map<String,Integer> vehicleSpeedChangeAnalysis;
    /////////////////////////////////
    /**
     * 实时数据  每隔六秒产生一条，十条数据，最后时间为当前时间
     */
    private Map<String,String> realtimeData;

    public static CurrentVehicleState getRandom(VehicleInfo vehicleInfo){
        CurrentVehicleState currentVehicleState = new CurrentVehicleState();
        Random random = new Random();

        int totalMileage = 5000 + random.nextInt(5000);
        currentVehicleState.setTotalMileage(totalMileage);
        int totalTravelTime = 300 + random.nextInt(150);
        currentVehicleState.setTotalTravelTime(totalTravelTime);
        int totalOil = 300 + random.nextInt(600);
        currentVehicleState.setTotalOil(totalOil);

        String symbol = random.nextInt(2) == 1?"+":"-";
        String verticalAcceleration = symbol + random.nextInt(24)/10.0;
        currentVehicleState.setVerticalAcceleration(verticalAcceleration);
        symbol = random.nextInt(2) == 1?"+":"-";
        String lateralAcceleration = symbol + random.nextInt(24)/10.0;
        currentVehicleState.setLateralAcceleration(lateralAcceleration);
        int speed = 30 + random.nextInt(40);
        currentVehicleState.setSpeed(speed);

        int currentOil = 50 + random.nextInt(50);
        currentVehicleState.setCurrentOil(currentOil);

        int engineSpeed = 800 + random.nextInt(2600);
        currentVehicleState.setEngineSpeed(engineSpeed);
        int engineTemperature = 80 + random.nextInt(10);
        currentVehicleState.setEngineWaterTemperature(engineTemperature);

        double tirePressure = (24 + random.nextInt(3))/10.0;
        currentVehicleState.setTirePressureLeftFront(tirePressure);
        int tireTemperature = 25 + random.nextInt(3);
        currentVehicleState.setTireTemperatureLeftFront(tireTemperature);
        tirePressure = (24 + random.nextInt(3))/10.0;
        currentVehicleState.setTirePressureLeftRear(tirePressure);
        tireTemperature = 25 + random.nextInt(3);
        currentVehicleState.setTireTemperatureLeftRear(tireTemperature);
        tirePressure = (24 + random.nextInt(3))/10.0;
        currentVehicleState.setTirePressureRightFront(tirePressure);
        tireTemperature = 25 + random.nextInt(3);
        currentVehicleState.setTireTemperatureRightFront(tireTemperature);
        tirePressure = (24 + random.nextInt(3))/10.0;
        currentVehicleState.setTirePressureRightRear(tirePressure);
        tireTemperature = 25 + random.nextInt(3);
        currentVehicleState.setTireTemperatureRightRear(tireTemperature);

        currentVehicleState.setVehicleInfo(vehicleInfo);
        currentVehicleState.setLongitude("100.3324");
        currentVehicleState.setAltitude("73.6624");
        currentVehicleState.setAlarmCondition("报警");
        currentVehicleState.setVehicleCondition("启动");
        long time = System.currentTimeMillis();
        long timeInterval = 6000;
        String lastEffectTime = dateTime(time);
        currentVehicleState.setLastEffectiveTime(lastEffectTime);

        Map<String,String> mapForData = new LinkedHashMap<>();
        for (int i = 1; i < 11; i++) {
            mapForData.put(dateTime(time-timeInterval*i),vehicleInfo.getVin());
        }
        currentVehicleState.setRealtimeData(mapForData);

        Map<String,Integer> mapForSpeed = new LinkedHashMap<>();
        for (int i = 1; i < 11; i++) {
            mapForSpeed.put(dateTime(time-timeInterval*i),30 + random.nextInt(40));
        }
        currentVehicleState.setVehicleSpeedChangeAnalysis(mapForSpeed);

        currentVehicleState.setTireSystem("正常");
        currentVehicleState.setTachometerSystem("正常");
        currentVehicleState.setBrakingSystem("正常");
        currentVehicleState.setEngineSystem("正常");

        return currentVehicleState;

    }

}
