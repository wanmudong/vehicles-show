package io.github.wanmudong.vehiclesshow.common.controller;

import io.github.wanmudong.vehiclesshow.common.domain.LargeScreenMonitoring;
import io.github.wanmudong.vehiclesshow.common.domain.StatisticsTotal;
import io.github.wanmudong.vehiclesshow.common.domain.UserDistribution;
import io.github.wanmudong.vehiclesshow.common.model.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/largeScreenMonitoring")
public class LargeScreenMonitoringController {

    @RequestMapping()
    public ResultVO getTotalData(){
        return ResultVO.success(LargeScreenMonitoring.getRandom());
    }
}
