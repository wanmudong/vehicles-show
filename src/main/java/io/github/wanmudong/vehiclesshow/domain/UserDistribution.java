package io.github.wanmudong.vehiclesshow.domain;

import lombok.Data;

import java.util.ArrayList;
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
     * 1000 900 800 ...
     * 在线数 3/4 +-20
     */
    List<UserDistributionOfProvince> country;

    /**
     * 二十三个省：河北省（冀）、山东省（齐）、辽宁省（辽）、黑龙江省（黑）、吉林省（吉）、甘肃省（陇）、青海省（青）、
     * 河南省（豫）、江苏省（苏）、湖北省（鄂）、湖南省（湘）、江西省（赣）、浙江省（浙）、广东省（粤）、云南省（滇）、
     * 福建省（福）、台湾省（台）、海南省（琼）、山西省（晋）、四川省（川）、陕西省（陕）、贵州省（黔）、安徽省（皖）。
     *
     * 四个直辖市：重庆市、北京市、上海市、天津市。
     *
     * 五个自治区：广西壮族自治区、内蒙古自治区、西藏自治区、新疆维吾尔自治区、宁夏回族自治区。
     *
     * 两个特别行政区：澳门特别行政区、香港特别行政区。
     */
    public static final String []  provinceList = {"安徽","浙江","江苏","上海","北京","广东",
                                                    "湖北","湖南","河北","山东","辽宁","黑龙江",
                                                    "吉林","陕西","贵州","四川","山西","海南",
                                                    "台湾","福建","云南","江西","湖北","河南",
                                                    "甘肃","重庆","内蒙古","天津","广西","西藏",
                                                    "新疆","澳门","香港"
                                                    };
    public static UserDistribution getRandomUserDistribution(StatisticsTotal statisticsTotal){
        int vehicleTotalNum = statisticsTotal.getVehicleTotalNum();
        int onlineTotalNum = statisticsTotal.getOnlineTotalNum();
        UserDistribution userDistribution = new UserDistribution();
        for (int i = 0; i < provinceList.length; i++) {

        }






        return userDistribution;
    }

    public static void main(String[] args) {
        System.out.println(provinceList.length);
    }
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

    /**
     * 在线数量与总数之比
     */
    public static final Double Online_To_Total_Ratio = 0.75;

    public static UserDistributionOfProvince getRandomProvince(String name, Integer totalNum){

        UserDistributionOfProvince ud = new UserDistributionOfProvince();
        ud.setName(name);
        ud.setTotalNum(totalNum);

        int onlineNum  = (int) (totalNum*Online_To_Total_Ratio);
        double QQRatio = Math.random() * 0.6;
        double JieTuRatio = Math.random() * 0.5;
        double RuiHuRatio = 1-QQRatio-JieTuRatio;
        int QQNum = (int) (onlineNum * QQRatio);
        int JieTuNum = (int) (onlineNum * JieTuRatio);
        int RuiHuNum = (int) (onlineNum * RuiHuRatio);
        ArrayList<Integer> modelList = new ArrayList<>();
        modelList.add(QQNum);
        modelList.add(JieTuNum);
        modelList.add(RuiHuNum);
        ud.setNumberOfModelsOnline(modelList);

        ud.setOnlineNum(onlineNum);
        ud.setOfflineNum(totalNum - onlineNum);

        return ud;
    }

    public static void main(String[] args) {
        System.out.println(getRandomProvince("anhui",3000));
    }
}