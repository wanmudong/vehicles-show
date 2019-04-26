package io.github.wanmudong.vehiclesshow.enums;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/25 21:37
 * @description： 车型
 * @modified By：
 * @version: $
 */
public enum  VehicleModel {
    RUIHU_5(1,"瑞虎5"),
    JIETU_7(2,"捷途7"),
    QQ(3,"QQ");
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

    private VehicleModel(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}