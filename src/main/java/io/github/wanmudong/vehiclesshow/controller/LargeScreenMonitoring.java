package io.github.wanmudong.vehiclesshow.controller;

import io.github.wanmudong.vehiclesshow.domain.StatisticsTotal;
import io.github.wanmudong.vehiclesshow.model.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/largeScreenMonitoring")
public class LargeScreenMonitoring {

    @RequestMapping()
    public ResultVO getTotalData(){
        Map<String,Object> totalMap = new HashMap<>();

        totalMap.put("total", StatisticsTotal.getRandomStatistics());
        return ResultVO.success(totalMap);
    }
}
