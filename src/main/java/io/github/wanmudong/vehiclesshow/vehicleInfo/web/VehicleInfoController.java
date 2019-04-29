package io.github.wanmudong.vehiclesshow.vehicleInfo.web;


import io.github.wanmudong.vehiclesshow.model.ResultVO;
import io.github.wanmudong.vehiclesshow.utils.ApplicationContextProvider;
import io.github.wanmudong.vehiclesshow.utils.MoniotrTask;
import io.github.wanmudong.vehiclesshow.utils.VehicleInfoGenerator;
import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.VehicleInfo;
import io.github.wanmudong.vehiclesshow.vehicleInfo.service.IVehicleInfoService;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanmudong
 * @since 2019-04-29
 */
@RestController
@RequestMapping("/vehicleInfo/vehicle-info")
public class VehicleInfoController {

    @Resource
    private IVehicleInfoService iVehicleInfoService;

    private static Logger logger = LoggerFactory.getLogger(VehicleInfoController.class);

    static final CountDownLatch countDownLatch = new CountDownLatch(12000);


    @RequestMapping(value = "/generate")
    public ResultVO generate() throws InterruptedException {

        BasicThreadFactory threadFactory = new BasicThreadFactory.Builder()
                .namingPattern("generator-thread-pool-%d")
                .daemon(false)
                .build();

        ThreadPoolExecutor poolTaskExecutor = new ThreadPoolExecutor(
                5,10,30, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1024),threadFactory);



        for (int i = 0; i < 12000; i++) {

//            poolTaskExecutor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    iVehicleInfoService.insert(info);
//                    countDownLatch.countDown();
//                }
//            });
//            iVehicleInfoService.insert(info);
            MoniotrTask m = ApplicationContextProvider.getBean("mTask", MoniotrTask.class);
            m.setLatch(countDownLatch);
            poolTaskExecutor.execute(m);

        }
        countDownLatch.await();
        return ResultVO.success("");
    }
}
