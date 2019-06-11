package io.github.wanmudong.vehiclesshow.common.controller;

import io.github.wanmudong.vehiclesshow.common.domain.LargeScreenMonitoring;
import io.github.wanmudong.vehiclesshow.common.model.ResultVO;
import io.github.wanmudong.vehiclesshow.common.utils.timeUtil;
import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.VehicleInfo;
import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.VehicleInfoDTO;
import io.github.wanmudong.vehiclesshow.vehicleInfo.service.IVehicleInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value = "/largeScreenMonitoring")
public class LargeScreenMonitoringController {
    @Resource
    private IVehicleInfoService iVehicleInfoService;

    @RequestMapping()
    public ResultVO getTotalData(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        List<VehicleInfoDTO> list = iVehicleInfoService.listVehicles(pageNo,pageSize);
        for(VehicleInfoDTO vehicleInfoDTO:list){
            vehicleInfoDTO.setDate(timeUtil.dateTime(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
        }
        LargeScreenMonitoring largeScreenMonitoring = LargeScreenMonitoring.getRandom();
        largeScreenMonitoring.setMessageUploadList(list);
        return ResultVO.success(largeScreenMonitoring);
    }
}
