package io.github.wanmudong.vehiclesshow.common.domain;

import lombok.Data;

import java.util.List;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/25 15:52
 * @description：用户分布
 * @modified By：
 * @version: $
 */
@Data
public class UserDistribution {
    /**
     * 省份列表
     */
    List<UserDistributionOfProvince> country;
}

@Data
class  UserDistributionOfProvince{
    /**
     * 省名
     */
    String name;
    /**
     * 各个车型的在线数量
     */
    List<Integer> numberOfModelsOnline;
    /**
     * 在线数量
     */
    Integer onlineNum;
    /**
     * 离线数量
     */
    Integer offlineNum;
    /**
     * 总数量
     */
    Integer totalNum;

    public static UserDistributionOfProvince getRandomProvince(){
        UserDistributionOfProvince ud = new UserDistributionOfProvince();
        return ud;
    }
}