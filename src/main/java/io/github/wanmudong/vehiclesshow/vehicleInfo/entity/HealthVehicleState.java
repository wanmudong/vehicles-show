package io.github.wanmudong.vehiclesshow.vehicleInfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/4 18:42
 * @description：二、车辆管理----车辆健康
 */
@Data
public class HealthVehicleState {
    /**
     * 发动机系统故障
     */
    private EngineSystemFault engineSystemFault;
    /**
     * 轮胎系统故障
     */
    private TireSystemFault tireSystemFault;
    /**
     * 制动系统故障
     */
    private BrokingSystemFault brokingSystemFault;
    /**
     * 辅助系统故障
     */
    private TechometerSystemFault techometerSystemFault;

    public static HealthVehicleState getRandom(VehicleInfo vehicleInfo){
        HealthVehicleState hvs = new HealthVehicleState();

        EngineSystemFault esf = new EngineSystemFault();
        esf = esf.getRandom(vehicleInfo);
        TireSystemFault tireSystemFault = new TireSystemFault();
        tireSystemFault = tireSystemFault.getRandom(vehicleInfo);
        BrokingSystemFault brokingSystemFault = new BrokingSystemFault();
        brokingSystemFault = brokingSystemFault.getRandom(vehicleInfo);
        TechometerSystemFault techometerSystemFault = new TechometerSystemFault();
        techometerSystemFault = techometerSystemFault.getRandom(vehicleInfo);

        hvs.setEngineSystemFault(esf);
        hvs.setTechometerSystemFault(techometerSystemFault);
        hvs.setBrokingSystemFault(brokingSystemFault);
        hvs.setTireSystemFault(tireSystemFault);

        return hvs;
    }
}
@Data
class EngineSystemFault{
    /**
     * 发动机系统故障总数
     */
    Integer totalEngineSystemFaultNum;
    /**
     * 发动机系统故障每月情况
     */
    Map<Integer,Integer> engineSystemFaultMap;
    /**
     * EPC指示
     */
    private EpcIndication epcIndication;
    /**
     * MIL灯
     */
    private MilLight milLight;
    @JsonIgnore
    private static final Integer MAX_NUM = 3;
    @Data
    private class EpcIndication{
        /**
         * EPC指示总数
         */
        Integer epcIndicationNum;
        /**
         * EPC指示每月情况
         */
        Map<Integer,Integer> epcIndicationMap;
    }
    @Data
    private class MilLight{
        /**
         * MIL灯总数
         */
        Integer milLightNum;
        /**
         * MIL灯每月情况
         */
        Map<Integer,Integer> milLightMap;
    }
    public  EngineSystemFault getRandom(VehicleInfo vehicleInfo){
        EngineSystemFault esf = new EngineSystemFault();
        Random random = new Random();

        EpcIndication ei = new EpcIndication();

        int totalEi = 0;
        Map<Integer,Integer> epcIndicationMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            epcIndicationMap.put(i,currentNum);
            totalEi += currentNum;
        }

        ei.setEpcIndicationNum(totalEi);
        ei.setEpcIndicationMap(epcIndicationMap);

        esf.setEpcIndication(ei);

        MilLight ml = new MilLight();

        int totalMl = 0;
        Map<Integer,Integer> milLightMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            milLightMap.put(i,currentNum);
            totalMl += currentNum;
        }

        ml.setMilLightNum(totalMl);
        ml.setMilLightMap(milLightMap);

        esf.setMilLight(ml);
        esf.setTotalEngineSystemFaultNum(totalEi+totalMl);

        Map<Integer,Integer> engineSystemFaultMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = epcIndicationMap.get(i)+milLightMap.get(i);
            engineSystemFaultMap.put(i,currentNum);
        }

        esf.setEngineSystemFaultMap(engineSystemFaultMap);

        return esf;

    }

}
@Data
class BrokingSystemFault{
    /**
     * 发动机系统故障总数
     */
    Integer brokingSystemFaultNum;
    /**
     * 发动机系统故障每月情况
     */
    Map<Integer,Integer> brokingSystemFaultMap;
    /**
     * EPB
     */
    private Ebp ebp;
    /**
     * EBD故障指示
     */
    private EbdIndication ebdIndication;
    /**
     * ABS故障指示
     */
    private AbsIndication absIndication;
    /**
     * EPS系统指示
     */
    private EpsIndication epsIndication;
    @JsonIgnore
    private static final Integer MAX_NUM = 2;
    @Data
    private class Ebp {
        /**
         * EPB总数
         */
        Integer ebpNum;
        /**
         * EPB每月情况
         */
        Map<Integer,Integer> ebpMap;
    }
    @Data
    private class EbdIndication {
        /**
         * EBD故障指示总数
         */
        Integer ebdIndicationNum;
        /**
         * EBD故障指示每月情况
         */
        Map<Integer,Integer> ebdIndicationMap;
    }
    @Data
    private class AbsIndication {
        /**
         * ABS故障指示总数
         */
        Integer absIndicationNum;
        /**
         * ABS故障指示每月情况
         */
        Map<Integer,Integer> absIndicationMap;
    }
    @Data
    private class EpsIndication {
        /**
         * EPS系统指示总数
         */
        Integer epsIndicationNum;
        /**
         * EPS系统指示每月情况
         */
        Map<Integer,Integer> epsIndicationMap;
    }
    public  BrokingSystemFault getRandom(VehicleInfo vehicleInfo){
        BrokingSystemFault bsf = new BrokingSystemFault();
        Random random = new Random();

        Ebp ebp = new Ebp();

        int totalEbp = 0;
        Map<Integer,Integer> ebpMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            ebpMap.put(i,currentNum);
            totalEbp += currentNum;
        }

        ebp.setEbpNum(totalEbp);
        ebp.setEbpMap(ebpMap);

        bsf.setEbp(ebp);

        EbdIndication ei = new EbdIndication();

        int totalEi = 0;
        Map<Integer,Integer> ebdIndicationMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            ebdIndicationMap.put(i,currentNum);
            totalEi += currentNum;
        }

        ei.setEbdIndicationNum(totalEi);
        ei.setEbdIndicationMap(ebdIndicationMap);

        bsf.setEbdIndication(ei);


        AbsIndication ai = new AbsIndication();

        int totalAi = 0;
        Map<Integer,Integer> absIndicationMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            absIndicationMap.put(i,currentNum);
            totalAi += currentNum;
        }

        ai.setAbsIndicationNum(totalAi);
        ai.setAbsIndicationMap(absIndicationMap);

        bsf.setAbsIndication(ai);


        EpsIndication epsIndicationi = new EpsIndication();

        int totalEpsIndication = 0;
        Map<Integer,Integer> epsIndicationiMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            epsIndicationiMap.put(i,currentNum);
            totalEpsIndication += currentNum;
        }

        epsIndicationi.setEpsIndicationNum(totalEpsIndication);
        epsIndicationi.setEpsIndicationMap(epsIndicationiMap);

        bsf.setEpsIndication(epsIndicationi);




        bsf.setBrokingSystemFaultNum(totalEi+totalEbp+totalEpsIndication+totalAi);

        Map<Integer,Integer> brokingSystemFaultMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = ebpMap.get(i)+ebdIndicationMap.get(i)+absIndicationMap.get(i)+epsIndicationiMap.get(i);
            brokingSystemFaultMap.put(i,currentNum);
        }

        bsf.setBrokingSystemFaultMap(brokingSystemFaultMap);

        return bsf;

    }
}
@Data
class TireSystemFault{
    /**
     * 轮胎系统故障总数
     */
    Integer tireEngineSystemFaultNum;
    /**
     * 轮胎系统故障每月情况
     */
    Map<Integer,Integer> tireEngineSystemFaultMap;
    /**
     * 左前轮胎压报警
     */
    private LeftFrontTirePressureAlarm leftFrontTirePressureAlarm;
    /**
     * ）左后轮胎压报警
     */
    private LeftRearTirePressureAlarm leftRearTirePressureAlarm;
    /**
     * ）右前轮胎压报
     */
    private RightFrontTirePressureAlarm rightFrontTirePressureAlarm;
    /**
     * ）右后轮胎压报警；
     */
    private RightRearTirePressureAlarm rightRearTirePressureAlarm;
    /**
     * 胎压报警灯状态
     */
    private TirePressureWarningLightStatus tirePressureWarningLightStatus;
    /**
     * ）胎压系统失效状态
     */
    private TirePressureSystemFailureState tirePressureSystemFailureState;
    /**
     * ）轮胎故障指示
     */
    private TireFaultIndication tireFaultIndication;
    @JsonIgnore
    private static final Integer MAX_NUM = 2;
    @Data
    private class LeftFrontTirePressureAlarm {
        /**
         *左前轮胎压报警总数
         */
        Integer leftFrontTirePressureAlarmNum;
        /**
         * 左前轮胎压报警每月情况
         */
        Map<Integer,Integer> leftFrontTirePressureAlarmMap;
    }
    @Data
    private class LeftRearTirePressureAlarm {
        /**
         * 左后轮胎压报警总数
         */
        Integer leftRearTirePressureAlarmNum;
        /**
         *左后轮胎压报警每月情况
         */
        Map<Integer,Integer> leftRearTirePressureAlarmMap;
    }
    @Data
    private class RightFrontTirePressureAlarm {
        /**
         * 右前轮胎压报总数
         */
        Integer rightFrontTirePressureAlarmNum;
        /**
         * 右前轮胎压报每月情况
         */
        Map<Integer,Integer> rightFrontTirePressureAlarmMap;
    }
    @Data
    private class RightRearTirePressureAlarm {
        /**
         * 右后轮胎压报警总数
         */
        Integer rightRearTirePressureAlarmNum;
        /**
         * 右后轮胎压报警每月情况
         */
        Map<Integer,Integer> rightRearTirePressureAlarmMap;
    }
    @Data
    private class TirePressureWarningLightStatus {
        /**
         * 胎压报警灯状态总数
         */
        Integer tirePressureWarningLightStatusNum;
        /**
         * 胎压报警灯状态每月情况
         */
        Map<Integer,Integer> tirePressureWarningLightStatusMap;
    }
    @Data
    private class TirePressureSystemFailureState {
        /**
         * 胎压系统失效状态总数
         */
        Integer tirePressureSystemFailureStateNum;
        /**
         * 胎压系统失效状态每月情况
         */
        Map<Integer,Integer> tirePressureSystemFailureStateMap;
    }
    @Data
    private class TireFaultIndication {
        /**
         * 轮胎故障指示总数
         */
        Integer tireFaultIndicationNum;
        /**
         * 轮胎故障指示每月情况
         */
        Map<Integer,Integer> tireFaultIndicationMap;
    }

    public  TireSystemFault getRandom(VehicleInfo vehicleInfo){
        TireSystemFault tsf = new TireSystemFault();
        Random random = new Random();

        LeftFrontTirePressureAlarm leftFrontTirePressureAlarm = new LeftFrontTirePressureAlarm();
        int leftFrontTirePressureAlarmNum = 0;
        Map<Integer,Integer> leftFrontTirePressureAlarmMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            leftFrontTirePressureAlarmMap.put(i,currentNum);
            leftFrontTirePressureAlarmNum += currentNum;
        }
        leftFrontTirePressureAlarm.setLeftFrontTirePressureAlarmNum(leftFrontTirePressureAlarmNum);
        leftFrontTirePressureAlarm.setLeftFrontTirePressureAlarmMap(leftFrontTirePressureAlarmMap);
        tsf.setLeftFrontTirePressureAlarm(leftFrontTirePressureAlarm);


        LeftRearTirePressureAlarm leftRearTirePressureAlarm = new LeftRearTirePressureAlarm();
        int leftRearTirePressureAlarmNum = 0;
        Map<Integer,Integer> leftRearTirePressureAlarmMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            leftRearTirePressureAlarmMap.put(i,currentNum);
            leftRearTirePressureAlarmNum += currentNum;
        }
        leftRearTirePressureAlarm.setLeftRearTirePressureAlarmNum(leftRearTirePressureAlarmNum);
        leftRearTirePressureAlarm.setLeftRearTirePressureAlarmMap(leftRearTirePressureAlarmMap);
        tsf.setLeftRearTirePressureAlarm(leftRearTirePressureAlarm);


        RightFrontTirePressureAlarm rightFrontTirePressureAlarm = new RightFrontTirePressureAlarm();
        int rightFrontTirePressureAlarmNum = 0;
        Map<Integer,Integer> rightFrontTirePressureAlarmMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            rightFrontTirePressureAlarmMap.put(i,currentNum);
            rightFrontTirePressureAlarmNum += currentNum;
        }
        rightFrontTirePressureAlarm.setRightFrontTirePressureAlarmNum(rightFrontTirePressureAlarmNum);
        rightFrontTirePressureAlarm.setRightFrontTirePressureAlarmMap(rightFrontTirePressureAlarmMap);
        tsf.setRightFrontTirePressureAlarm(rightFrontTirePressureAlarm);


        RightRearTirePressureAlarm rightRearTirePressureAlarm = new RightRearTirePressureAlarm();
        int rightRearTirePressureAlarmNum = 0;
        Map<Integer,Integer> rightRearTirePressureAlarmMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            rightRearTirePressureAlarmMap.put(i,currentNum);
            rightRearTirePressureAlarmNum += currentNum;
        }
        rightRearTirePressureAlarm.setRightRearTirePressureAlarmNum(rightRearTirePressureAlarmNum);
        rightRearTirePressureAlarm.setRightRearTirePressureAlarmMap(rightRearTirePressureAlarmMap);
        tsf.setRightRearTirePressureAlarm(rightRearTirePressureAlarm);

        TirePressureWarningLightStatus tirePressureWarningLightStatus = new TirePressureWarningLightStatus();
        int tirePressureWarningLightStatusNum = 0;
        Map<Integer,Integer> tirePressureWarningLightStatusMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            tirePressureWarningLightStatusMap.put(i,currentNum);
            tirePressureWarningLightStatusNum += currentNum;
        }
        tirePressureWarningLightStatus.setTirePressureWarningLightStatusNum(tirePressureWarningLightStatusNum);
        tirePressureWarningLightStatus.setTirePressureWarningLightStatusMap(tirePressureWarningLightStatusMap);
        tsf.setTirePressureWarningLightStatus(tirePressureWarningLightStatus);

        TirePressureSystemFailureState tirePressureSystemFailureState = new TirePressureSystemFailureState();
        int tirePressureSystemFailureStateNum = 0;
        Map<Integer,Integer> tirePressureSystemFailureStateMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            tirePressureSystemFailureStateMap.put(i,currentNum);
            tirePressureSystemFailureStateNum += currentNum;
        }
        tirePressureSystemFailureState.setTirePressureSystemFailureStateNum(tirePressureSystemFailureStateNum);
        tirePressureSystemFailureState.setTirePressureSystemFailureStateMap(tirePressureSystemFailureStateMap);
        tsf.setTirePressureSystemFailureState(tirePressureSystemFailureState);

        TireFaultIndication tireFaultIndication = new TireFaultIndication();
        int tireFaultIndicationNum = 0;
        Map<Integer,Integer> tireFaultIndicationMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            tireFaultIndicationMap.put(i,currentNum);
            tireFaultIndicationNum += currentNum;
        }
        tireFaultIndication.setTireFaultIndicationNum(tireFaultIndicationNum);
        tireFaultIndication.setTireFaultIndicationMap(tireFaultIndicationMap);
        tsf.setTireFaultIndication(tireFaultIndication);


        tsf.setTireEngineSystemFaultNum(rightFrontTirePressureAlarmNum+rightRearTirePressureAlarmNum+leftFrontTirePressureAlarmNum+leftRearTirePressureAlarmNum
                +tirePressureWarningLightStatusNum+tirePressureSystemFailureStateNum+tireFaultIndicationNum);
        Map<Integer,Integer> brokingSystemFaultMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = rightFrontTirePressureAlarmMap.get(i)+rightRearTirePressureAlarmMap.get(i)+leftRearTirePressureAlarmMap.get(i)+leftFrontTirePressureAlarmMap.get(i)
                    +tirePressureWarningLightStatusMap.get(i)+tirePressureSystemFailureStateMap.get(i);
            brokingSystemFaultMap.put(i,currentNum);
        }
        tsf.setTireEngineSystemFaultMap(brokingSystemFaultMap);

        return tsf;

    }
}
@Data
class TechometerSystemFault{
    /**
     * 变速器系统故障总数
     */
    Integer techometerSystemFaultNum;
    /**
     * 变速器系统故障每月情况
     */
    Map<Integer,Integer> techometerSystemFaultMap;
    /**
     * 变速箱故障指示
     */
    private GearboxFaultIndication gearboxFaultIndication;

    @JsonIgnore
    private static final Integer MAX_NUM = 3;
    @Data
    private class GearboxFaultIndication {
        /**
         * 变速箱故障指示总数
         */
        Integer gearboxFaultIndicationNum;
        /**
         * 变速箱故障指示每月情况
         */
        Map<Integer,Integer> gearboxFaultIndicationMap;
    }
    public  TechometerSystemFault getRandom(VehicleInfo vehicleInfo){
        TechometerSystemFault tsf = new TechometerSystemFault();
        Random random = new Random();

        GearboxFaultIndication gearboxFaultIndication = new GearboxFaultIndication();
        int gearboxFaultIndicationNum = 0;
        Map<Integer,Integer> gearboxFaultIndicationMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = random.nextInt(MAX_NUM);
            gearboxFaultIndicationMap.put(i,currentNum);
            gearboxFaultIndicationNum += currentNum;
        }
        gearboxFaultIndication.setGearboxFaultIndicationNum(gearboxFaultIndicationNum);
        gearboxFaultIndication.setGearboxFaultIndicationMap(gearboxFaultIndicationMap);
        tsf.setGearboxFaultIndication(gearboxFaultIndication);


        tsf.setTechometerSystemFaultNum(gearboxFaultIndicationNum);
        Map<Integer,Integer> engineSystemFaultMap = new LinkedHashMap<>(12);
        for (int i = 1; i <13; i++) {
            int currentNum = gearboxFaultIndicationMap.get(i);
            engineSystemFaultMap.put(i,currentNum);
        }
        tsf.setTechometerSystemFaultMap(engineSystemFaultMap);

        return tsf;

    }
}
