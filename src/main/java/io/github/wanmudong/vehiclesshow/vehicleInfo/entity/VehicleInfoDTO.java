package io.github.wanmudong.vehiclesshow.vehicleInfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/6/11 15:53
 * @description：
 */
@Data
public class VehicleInfoDTO {
    /**
     * 车辆标识VIN
     */
    private String vin;

    /**
     * 车型（0、QQ；1、瑞虎5；2、捷途7）
     */
    private String model;

    /**
     * 车辆所在地区（二分之一是安徽，五分之一是浙江，五分之一是江苏，五分之一是上海，五分之一是北京，其余省市分剩下的五分之一）
     */
    private String area;

    /**
     * 是否在线（1为在线，0为离线）
     */
    private String isOnline;

    /**
     * 驾驶风格（0：冲动型，1：平稳型，2：一般型 比例为2:3:5）
     */
    private String drivenStyle;

    /**
     * 故障数（30-50）
     */
    private Integer numberOfFailures;
}
