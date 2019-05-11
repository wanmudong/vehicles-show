package io.github.wanmudong.vehiclesshow.vehicleInfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/11 21:47
 * @description：三、故障分析
 */
@Data
public class FailureAnalysis {
    private FaultOverview faultOverview;

    private FaultDistribution faultDistribution;

    //故障车辆列表
    private List faultVehicleList;

    public static FailureAnalysis getRandom(List faultVehicleList){
        FailureAnalysis failureAnalysis = new FailureAnalysis();

        failureAnalysis.setFaultDistribution(FaultDistribution.getRandom());
        failureAnalysis.setFaultOverview(FaultOverview.getRandom());
        failureAnalysis.setFaultVehicleList(faultVehicleList);

        return failureAnalysis;
    }
}

/**
 * 故障总览
 */
@Data
class FaultOverview{
    /**
     * 所有故障
     */
    private int totalFailure;
    /**
     * 发动机系统故障
     */
    private int engineSystemFailure;
    /**
     * 制动系统故障
     */
    private int brokingSystemFailure;
    /**
     * 轮胎系统故障
     */
    private int tireSystemFailure;
    /**
     * 制动器系统故障
     */
    private int brakeSystemFailure;

    public static FaultOverview getRandom(){
        FaultOverview faultOverview = new FaultOverview();
        Random random = new Random();

        int totalFailure = 250000 + random.nextInt(10000);
        faultOverview.setTotalFailure(totalFailure);
        int engineSystemFailure = 60000 + random.nextInt(2500);
        faultOverview.setEngineSystemFailure(engineSystemFailure);
        int brokingSystemFailure = 60000 + random.nextInt(2500);
        faultOverview.setBrokingSystemFailure(brokingSystemFailure);
        int tireSystemFailure = 60000 + random.nextInt(2500);
        faultOverview.setTireSystemFailure(tireSystemFailure);
        int brakeSystemFailure = 60000 + random.nextInt(2500);
        faultOverview.setBrakeSystemFailure(brakeSystemFailure);

        return faultOverview;
    }
}

/**
 * 故障分布
 */
@Data
class FaultDistribution{
    private Map<Integer,Map<Integer,Integer>> faultMap;
    @JsonIgnore
    private static final int VEHICLE_MODELS_NUM = 3;
    @JsonIgnore
    private static final int VEHICLE_FAULT_NUM = 4;
//    private static final String [] VehicleFaultArray={"发动机系统故障","制动系统故障","轮胎系统故障","转速器系统故障"};

    public static FaultDistribution getRandom(){
        FaultDistribution faultDistribution = new FaultDistribution();
        Map<Integer,Map<Integer,Integer>> faultVehicleMap = new HashMap<>(16);
        Random random = new Random();

        for (int i = 0; i < VEHICLE_MODELS_NUM; i++) {
            Map<Integer,Integer> faultMap = new HashMap<>(16);
            for (int j = 0; j < VEHICLE_FAULT_NUM; j++) {
                int faultNum = 14000 + random.nextInt(2000);
                faultMap.put(j,faultNum);
            }
            faultVehicleMap.put(i,faultMap);
        }
        faultDistribution.setFaultMap(faultVehicleMap);
        return faultDistribution;
    }
}

///**
// * 故障车辆列表
// */
//@Data
//class FaultVehicleList{
//    List<VehicleInfo> vehicleInfos;
//
//    public static FaultVehicleList getRandom(){
//
//    }
//}