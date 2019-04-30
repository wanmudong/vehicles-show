package io.github.wanmudong.vehiclesshow.common.enums;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/25 21:37
 * @description： 故障类型
 * @modified By：
 * @version: $
 */
public enum VehicleFault {
    ENGINE_SYSTEM_FAULT(1,"发动机系统故障"),
    BROKING_SYSTEM_FAULT(1,"制动系统故障"),
    TIRE_SYSTEM_FAULT(2,"轮胎系统故障"),
    TACHOMETER_SYSTEM_FAULT(3,"转速器系统故障");
    private Integer value;
    private String desc;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private VehicleFault(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}