package io.github.wanmudong.vehiclesshow.vehicleInfo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.github.wanmudong.vehiclesshow.common.utils.MyPageInfo;
import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.VehicleInfo;
import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.VehicleInfoDTO;
import io.github.wanmudong.vehiclesshow.vehicleInfo.mapper.VehicleInfoMapper;
import io.github.wanmudong.vehiclesshow.vehicleInfo.service.IVehicleInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanmudong
 * @since 2019-04-29
 */
@Service
public class VehicleInfoServiceImpl extends ServiceImpl<VehicleInfoMapper, VehicleInfo> implements IVehicleInfoService {

    @Override
    public MyPageInfo listVehicles(String vin,int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        EntityWrapper<VehicleInfo> ew = new EntityWrapper<>();
        ew.orderBy("id");
        if (StringUtils.isNotEmpty(vin)){
            ew.eq("vin",vin);
        }

        PageInfo<VehicleInfo> pageInfo = new PageInfo<>(baseMapper.selectList(ew));
        List<VehicleInfo>list = pageInfo.getList();
        List<VehicleInfoDTO> infoDTOList = new ArrayList<>();
        for(VehicleInfo vehicleInfo:list){
            VehicleInfoDTO vehicleInfoDTO = vehicleInfo.doTODto();
            infoDTOList.add(vehicleInfoDTO);
        }
        return new MyPageInfo<>(pageInfo,infoDTOList);
    }

    @Override
    public List<VehicleInfoDTO> listVehicles(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        EntityWrapper<VehicleInfo> ew = new EntityWrapper<>();
        ew.orderBy("id");

        PageInfo<VehicleInfo> pageInfo = new PageInfo<>(baseMapper.selectList(ew));
        List<VehicleInfo>list =pageInfo.getList();
        List<VehicleInfoDTO> infoDTOList = new ArrayList<>();
        for(VehicleInfo vehicleInfo:list){
            VehicleInfoDTO vehicleInfoDTO = vehicleInfo.doTODto();
            infoDTOList.add(vehicleInfoDTO);
        }
        return infoDTOList;
    }

    @Override
    public List listVehiclesByProvince(String province, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        EntityWrapper<VehicleInfo> ew = new EntityWrapper<>();
        ew.orderBy("id");
        if (StringUtils.isNotEmpty(province)){
            ew.eq("area",province);
        }
        PageInfo<VehicleInfo> pageInfo = new PageInfo<>(baseMapper.selectList(ew));
        List<VehicleInfo>list =pageInfo.getList();
        List<VehicleInfoDTO> infoDTOList = new ArrayList<>();
        for(VehicleInfo vehicleInfo:list){
            VehicleInfoDTO vehicleInfoDTO = vehicleInfo.doTODto();
            infoDTOList.add(vehicleInfoDTO);
        }
        return infoDTOList;
    }
}
