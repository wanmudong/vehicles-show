package io.github.wanmudong.vehiclesshow.common.controller;

import io.github.wanmudong.vehiclesshow.common.model.ResultVO;
import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.FailureAnalysis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/6/24 11:28
 * @description：
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/")
    public String login(){
        return "index";
    }
}
