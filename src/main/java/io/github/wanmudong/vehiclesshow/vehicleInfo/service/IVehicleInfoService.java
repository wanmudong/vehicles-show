package io.github.wanmudong.vehiclesshow.vehicleInfo.service;

import io.github.wanmudong.vehiclesshow.utils.MyPageInfo;
import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.VehicleInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanmudong
 * @since 2019-04-29
 */
public interface IVehicleInfoService extends IService<VehicleInfo> {

    MyPageInfo listVehicles(String vin, int pageNo, int pageSize);
}
