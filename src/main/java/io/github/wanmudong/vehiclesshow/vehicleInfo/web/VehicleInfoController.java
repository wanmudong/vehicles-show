package io.github.wanmudong.vehiclesshow.vehicleInfo.web;


import io.github.wanmudong.vehiclesshow.model.ResultVO;
import io.github.wanmudong.vehiclesshow.utils.ApplicationContextProvider;
import io.github.wanmudong.vehiclesshow.utils.MoniotrTask;
import io.github.wanmudong.vehiclesshow.utils.MyPageInfo;
import io.github.wanmudong.vehiclesshow.utils.VehicleInfoGenerator;
import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.VehicleInfo;
import io.github.wanmudong.vehiclesshow.vehicleInfo.service.IVehicleInfoService;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.LinkedHashMap;
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
                30,30,30, TimeUnit.SECONDS,new LinkedBlockingDeque<>(12000),threadFactory);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 12000; i++) {
            MoniotrTask m = ApplicationContextProvider.getBean("mTask", MoniotrTask.class);
            m.setLatch(countDownLatch);
            poolTaskExecutor.execute(m);
            logger.info("这里是主线程："+i);

        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        logger.info("一共用时"+(endTime-startTime)/1000+"秒");
        return ResultVO.success("");
    }

    /**
     * 列表分页查询车辆信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    public ResultVO list(String vin,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        MyPageInfo myPageInfo = iVehicleInfoService.listVehicles(vin,pageNo,pageSize);
        return ResultVO.success(myPageInfo);
    }

    @RequestMapping(value = "/detail")
    public ResultVO detail(){
        LinkedHashMap<Integer,Object> map = new LinkedHashMap<>();
        return ResultVO.success(map);
    }


}
