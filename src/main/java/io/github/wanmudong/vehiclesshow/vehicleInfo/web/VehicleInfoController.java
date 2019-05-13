package io.github.wanmudong.vehiclesshow.vehicleInfo.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.*;
import io.github.wanmudong.vehiclesshow.common.model.ResultVO;
import io.github.wanmudong.vehiclesshow.common.utils.ApplicationContextProvider;
import io.github.wanmudong.vehiclesshow.common.utils.MoniotrTask;
import io.github.wanmudong.vehiclesshow.common.utils.MyPageInfo;
import io.github.wanmudong.vehiclesshow.vehicleInfo.service.IVehicleInfoService;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
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

    static final CountDownLatch countDownLatch = new CountDownLatch(400);


    @RequestMapping(value = "/generate")
    public ResultVO generate() throws InterruptedException {

        BasicThreadFactory threadFactory = new BasicThreadFactory.Builder()
                .namingPattern("generator-thread-pool-%d")
                .daemon(false)
                .build();

        ThreadPoolExecutor poolTaskExecutor = new ThreadPoolExecutor(
                30,30,30, TimeUnit.SECONDS,new LinkedBlockingDeque<>(12000),threadFactory);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 400; i++) {
            MoniotrTask m = ApplicationContextProvider.getBean("mTask", MoniotrTask.class);
            m.setLatch(countDownLatch);
            poolTaskExecutor.execute(m);
            logger.info("这里是主线程："+i);

        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        logger.info("一共用时"+(endTime-startTime)/1000+"秒");
        return ResultVO.success("一共用时"+(endTime-startTime)/1000+"秒");
    }

    /**
     * 列表分页查询车辆信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    public ResultVO list(String vin,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        try {
            MyPageInfo myPageInfo = iVehicleInfoService.listVehicles(vin,pageNo,pageSize);
            return ResultVO.success(myPageInfo);
        }catch (Exception e){
            return ResultVO.fail("访问失败，请检查！");
        }
    }

    @RequestMapping(value = "/detail")
    public ResultVO detail(String vin){
        try {
            VehicleInfo vi = iVehicleInfoService.selectOne(new EntityWrapper<VehicleInfo>().eq("vin", vin));
            CurrentVehicleState cvs = CurrentVehicleState.getRandom(vi);
            return ResultVO.success(cvs);
        }catch (Exception e){
            return ResultVO.fail("访问失败，请检查！");
        }

    }
    @RequestMapping(value = "/history")
    public ResultVO history(String vin){
        try {
            VehicleInfo vi = iVehicleInfoService.selectOne(new EntityWrapper<VehicleInfo>().eq("vin", vin));
            HistoryVehicleState hvs = HistoryVehicleState.getRandom(vi);
            return ResultVO.success(hvs);
        }catch (Exception e){
            return ResultVO.fail("访问失败，请检查！");
        }

    }
    @RequestMapping(value = "/health")
    public ResultVO health(String vin){
        try {
            VehicleInfo vi = iVehicleInfoService.selectOne(new EntityWrapper<VehicleInfo>().eq("vin", vin));
            HealthVehicleState hvs = HealthVehicleState.getRandom(vi);
            return ResultVO.success(hvs);
        }catch (Exception e){
            return ResultVO.fail("访问失败，请检查！");
        }

    }
    @RequestMapping(value = "/drivenBehavior")
    public ResultVO drivenBehavior(String vin){
        try {
            VehicleInfo vi = iVehicleInfoService.selectOne(new EntityWrapper<VehicleInfo>().eq("vin", vin));
            DrivingBehavior hvs = DrivingBehavior.getRandom(vi);
            return ResultVO.success(hvs);
        }catch (Exception e){
            return ResultVO.fail("访问失败，请检查！");
        }

    }
    @RequestMapping(value = "/failureAnalysis")
    public ResultVO failureAnalysis(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        try {
            List list = iVehicleInfoService.listVehicles(pageNo,pageSize);
            FailureAnalysis failureAnalysis = FailureAnalysis.getRandom(list);
            return ResultVO.success(failureAnalysis);
        }catch (Exception e){
            return ResultVO.fail("访问失败，请检查！");
        }

    }

    @RequestMapping(value = "/drivingStyleAnalysis")
    public ResultVO drivingStyleAnalysis(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        try {
            List list = iVehicleInfoService.listVehicles(pageNo,pageSize);
            DrivingStyle drivingStyle = DrivingStyle.getRandom(list);
            return ResultVO.success(drivingStyle);
        }catch (Exception e){
            return ResultVO.fail("访问失败，请检查！");
        }

    }
    @RequestMapping(value = "/drivingStyleAnalysis/province")
    public ResultVO drivingStyleAnalysisOfProvince(String province){
        try {
            /**
             * 二分之一是安徽，五分之一是浙江，五分之一是江苏，五分之一是上海，五分之一是北京，其余省市分剩下的五分之一
             */
            int totalNum = 12000;
            if ("anHui".equals(province)){
                totalNum = (int) (totalNum*(0.5));
            }else {
                totalNum = (int) (totalNum*(0.2));
            }
            DrivingStyle drivingStyle = DrivingStyle.getRandomOfProvince(totalNum);
            return ResultVO.success(drivingStyle);
        }catch (Exception e){
            return ResultVO.fail("访问失败，请检查！");
        }

    }

}
