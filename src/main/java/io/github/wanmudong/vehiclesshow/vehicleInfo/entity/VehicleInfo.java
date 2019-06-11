package io.github.wanmudong.vehiclesshow.vehicleInfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import io.github.wanmudong.vehiclesshow.common.utils.ArrConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanmudong
 * @since 2019-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("vehicle_info")
public class VehicleInfo extends Model<VehicleInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 车辆标识VIN
     */
    private String vin;

    /**
     * 车型（0、瑞虎5；1、QQ；2、捷途7）
     */
    private Integer model;



    /**
     * 车辆所在地区（二分之一是安徽，五分之一是浙江，五分之一是江苏，五分之一是上海，五分之一是北京，其余省市分剩下的五分之一）
     */
    private String area;

    /**
     * 是否在线（1为在线，0为离线）
     */
    @TableField("is_online")
    private Integer isOnline;


    /**
     * 驾驶风格（0：冲动型，1：平稳型，2：一般型 比例为2:3:5）
     */
    @TableField("driven_style")
    private Integer drivenStyle;



    /**
     * 故障数（30-50）
     */
    @TableField("number_of_failures")
    private Integer numberOfFailures;


    @Override
    protected Serializable pkVal() {
        return null;
    }

    public VehicleInfoDTO doTODto(){
        VehicleInfoDTO dto = new VehicleInfoDTO();
        dto.setArea(area);
        dto.setDrivenStyle(ArrConstant.drivenStylelArr[drivenStyle]);
        dto.setIsOnline(ArrConstant.onlineArr[isOnline]);
        dto.setModel(ArrConstant.modelArr[model]);
        dto.setVin(vin);
        dto.setNumberOfFailures(numberOfFailures);
        return dto;
    }

}
