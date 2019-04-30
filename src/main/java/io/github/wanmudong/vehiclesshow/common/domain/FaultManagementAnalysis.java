package io.github.wanmudong.vehiclesshow.common.domain;

import io.github.wanmudong.vehiclesshow.common.enums.VehicleFault;
import io.github.wanmudong.vehiclesshow.common.enums.VehicleModel;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/30 18:17
 * @description：故障管理分析
 */
@Data
public class FaultManagementAnalysis {
    Map<String,Integer> typeMap;
    Map<String,Integer> modelMap;

    public static FaultManagementAnalysis getRandom(){
        FaultManagementAnalysis fa = new FaultManagementAnalysis();
        Map<String,Integer> typeMap = new LinkedHashMap<>();
        Map<String,Integer> modelMap = new LinkedHashMap<>();
        Random random = new Random();

        int engineSystemFault = 15 + random.nextInt(10);
        typeMap.put(VehicleFault.ENGINE_SYSTEM_FAULT.getDesc(),engineSystemFault);
        int tireSystemFault = 15 + random.nextInt(10);
        typeMap.put(VehicleFault.TIRE_SYSTEM_FAULT.getDesc(),tireSystemFault);
        int brokingSystemFault = 15 + random.nextInt(10);
        typeMap.put(VehicleFault.ENGINE_SYSTEM_FAULT.getDesc(),brokingSystemFault);
        int techometerSystemFault = 100 - engineSystemFault - brokingSystemFault - tireSystemFault;
        typeMap.put(VehicleFault.TACHOMETER_SYSTEM_FAULT.getDesc(),techometerSystemFault);

        int qq = 25 + random.nextInt(10);
        modelMap.put(VehicleModel.QQ.getDesc(),qq);
        int ruiHu = 25 + random.nextInt(10);
        modelMap.put(VehicleModel.RUIHU_5.getDesc(),ruiHu);
        int jieTu =100 - qq - ruiHu;
        modelMap.put(VehicleModel.JIETU_7.getDesc(),jieTu);

        fa.setModelMap(modelMap);
        fa.setTypeMap(typeMap);

        return fa;
    }
}
