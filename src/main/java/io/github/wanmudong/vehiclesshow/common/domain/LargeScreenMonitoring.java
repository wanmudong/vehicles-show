package io.github.wanmudong.vehiclesshow.common.domain;

import io.github.wanmudong.vehiclesshow.vehicleInfo.service.IVehicleInfoService;
import lombok.Data;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/30 18:41
 * @description：大屏监控
 */
@Data
public class LargeScreenMonitoring {


    private StatisticsTotal statisticsTotal;

    private UserDistribution userDistribution;

    private CurrentOnlineVehicle currentOnlineVehicle;

    private AlarmState alarmState;

    private AccessToInternational accessToInternational;

    private FaultManagementAnalysis faultManagementAnalysis;

    private List MessageUploadList;

    public static LargeScreenMonitoring getRandom(){
        LargeScreenMonitoring lm = new LargeScreenMonitoring();

        StatisticsTotal st = StatisticsTotal.getRandomStatistics();
        lm.setStatisticsTotal(st);
        UserDistribution ud = UserDistribution.getRandomUserDistribution(st);
        lm.setUserDistribution(ud);
        CurrentOnlineVehicle cv = CurrentOnlineVehicle.getRandom(st);
        lm.setCurrentOnlineVehicle(cv);
        AlarmState as = AlarmState.getRandom(st);
        lm.setAlarmState(as);
        FaultManagementAnalysis fa = FaultManagementAnalysis.getRandom();
        lm.setFaultManagementAnalysis(fa);
        AccessToInternational at = AccessToInternational.getRandom();
        lm.setAccessToInternational(at);

        return lm;
    }
}
