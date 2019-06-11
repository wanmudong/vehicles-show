package io.github.wanmudong.vehiclesshow.common.domain;

import io.github.wanmudong.vehiclesshow.common.enums.VehicleModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
     * 1000 900 800 ...
     * 在线数 3/4 +-20
     */
    ArrayList<UserDistributionOfProvince> country = new ArrayList<>();

    /**
     * 二十三个省：河北省（冀）、山东省（齐）、辽宁省（辽）、黑龙江省（黑）、吉林省（吉）、甘肃省（陇）、青海省（青）、
     * 河南省（豫）、江苏省（苏）、湖北省（鄂）、湖南省（湘）、江西省（赣）、浙江省（浙）、广东省（粤）、云南省（滇）、
     * 福建省（福）、台湾省（台）、海南省（琼）、山西省（晋）、四川省（川）、陕西省（陕）、贵州省（黔）、安徽省（皖）。
     * <p>
     * 四个直辖市：重庆市、北京市、上海市、天津市。
     * <p>
     * 五个自治区：广西壮族自治区、内蒙古自治区、西藏自治区、新疆维吾尔自治区、宁夏回族自治区。
     * <p>
     * 两个特别行政区：澳门特别行政区、香港特别行政区。
     */
    public static final String[] PROVINCE_ALL = {"安徽", "上海", "北京", "浙江", "江苏", "广东",
            "湖北", "湖南", "河北", "山东", "辽宁", "黑龙江",
            "吉林", "陕西", "贵州", "四川", "山西", "海南",
            "台湾", "福建", "云南", "江西", "湖北", "河南",
            "甘肃", "重庆", "内蒙古", "天津", "广西", "西藏",
            "新疆", "澳门", "香港"
    };
    public static final String[] PROVINCE = {"安徽", "上海", "北京", "浙江", "江苏","广东", "其他"};

    /**
     * 安徽占三分之一，其余五省市占三分之一，剩余占其余三分之一
     * 安徽3000，北京2500，上海1500 浙江 1500 江苏 1500 其他 2000
     * @param statisticsTotal
     * @return
     */
    public static UserDistribution getRandomUserDistribution(StatisticsTotal statisticsTotal) {
        int vehicleTotalNum = statisticsTotal.getVehicleTotalNum();
        Random random = new Random();
        int onlineTotalNum = statisticsTotal.getOnlineTotalNum();
        double ratio = 1.0;
        double innerRatio =  ratio/4;
        UserDistribution ud = new UserDistribution();

        int [] vehicleNum = {3011,2492,1555,1310,1060,1260,1309};

        for (int i = 0; i < PROVINCE.length; i++) {

            UserDistributionOfProvince up = UserDistributionOfProvince
                    .getRandomProvince(PROVINCE[i],vehicleNum[i]);

            ud.getCountry().add(up);

//            if (i == 0){
//                UserDistributionOfProvince up = UserDistributionOfProvince
//                        .getRandomProvince(PROVINCE[i],vehicleNum[i]);
//
//                ud.getCountry().add(up);
//            }else if(i == 1){
//                UserDistributionOfProvince up = UserDistributionOfProvince
//                        .getRandomProvince(PROVINCE[i],vehicleNum[i]);
//
//                ud.getCountry().add(up);
//
//            }else if (i<6){
//               double nowRatio = innerRatio * 0.2;
//                UserDistributionOfProvince up = UserDistributionOfProvince
//                        .getRandomProvince(PROVINCE[i],vehicleNum[i]);
//
//                ud.getCountry().add(up);
//            }else {
//                double nowRatio = innerRatio * 0.037;
//                UserDistributionOfProvince up = UserDistributionOfProvince
//                        .getRandomProvince(PROVINCE[i],new Double(nowRatio*vehicleTotalNum).intValue());
//
//                ud.getCountry().add(up);
//            }
        }


        return ud;
    }

}
@Data
class  UserDistributionOfProvince {
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

    /**
     * 在线数量与总数之比
     */
//    public static  Double Online_To_Total_Ratio = 0.75;

    public static UserDistributionOfProvince getRandomProvince(String name, int totalNum) {

        Random random = new Random();
        UserDistributionOfProvince ud = new UserDistributionOfProvince();
        ud.setName(name);
        ud.setTotalNum(totalNum);

        double Online_To_Total_Ratio = 0.4 + random.nextDouble()/4;
        int onlineNum = (int) (totalNum * Online_To_Total_Ratio);
        double QQRatio = Math.random() * 0.6;
        double JieTuRatio = Math.random() * 0.5;
        double RuiHuRatio = 1 - QQRatio - JieTuRatio;
        /**
         * 全部车辆数即瑞虎5车辆数，其余两个车型均为0
         */
//        int QQNum = (int) (onlineNum * QQRatio);
//        int JieTuNum = (int) (onlineNum * JieTuRatio);
//        int RuiHuNum = (int) (onlineNum * RuiHuRatio);
        int QQNum = 0;
        int JieTuNum = 0;
        int RuiHuNum = onlineNum;

        ArrayList<Integer> modelList = new ArrayList<>();
        modelList.add(RuiHuNum);
        modelList.add(QQNum);
        modelList.add(JieTuNum);
        ud.setNumberOfModelsOnline(modelList);
        ud.setOnlineNum(onlineNum);
        ud.setOfflineNum(totalNum - onlineNum);

        return ud;
    }

//    public static void main(String[] args) {
//        System.out.println(UserDistributionOfProvince.getRandomProvince(UserDistribution.PROVINCE[0],1000));
//    }
}