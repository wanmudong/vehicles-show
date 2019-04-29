package io.github.wanmudong.vehiclesshow.utils;

import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.VehicleInfo;
import io.github.wanmudong.vehiclesshow.vehicleInfo.service.IVehicleInfoService;
import io.github.wanmudong.vehiclesshow.vehicleInfo.web.VehicleInfoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.management.monitor.Monitor;
import java.util.concurrent.CountDownLatch;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/29 10:48
 * @description：
 * @modified By：
 * @version: $
 */
@Component("mTask")
@Scope("prototype")
public class MoniotrTask extends Thread {

    final static Logger logger= LoggerFactory.getLogger(MoniotrTask.class);
    //参数封装
    private Monitor monitor;
    private VehicleInfo vehicleInfo;
    CountDownLatch latch;

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
    public void setVehicleInfo(VehicleInfo vehicleInfo){
        this.vehicleInfo = vehicleInfo;
    }

    @Resource(name = "vehicleInfoServiceImpl")
    private IVehicleInfoService iVehicleInfoService;

    @Override
    public void run() {
        VehicleInfoGenerator vig = new VehicleInfoGenerator();
        VehicleInfo info = vig.generator();
        iVehicleInfoService.insert(info);
        logger.info("正在插入车辆信息，当前车辆VIN号为："+info.getVin());
        latch.countDown();
    }


}