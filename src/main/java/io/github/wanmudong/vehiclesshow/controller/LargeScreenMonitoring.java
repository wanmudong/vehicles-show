package io.github.wanmudong.vehiclesshow.controller;

import io.github.wanmudong.vehiclesshow.domain.StatisticsTotal;
import io.github.wanmudong.vehiclesshow.model.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/largeScreenMonitoring")
public class LargeScreenMonitoring {

    @RequestMapping()
    public ResultVo getTotalData(){
        Map<String,Object> totalMap = new HashMap<>();

        totalMap.put("total", StatisticsTotal.getRandomStatistics());
        return ResultVo.success(totalMap);
    }
}
