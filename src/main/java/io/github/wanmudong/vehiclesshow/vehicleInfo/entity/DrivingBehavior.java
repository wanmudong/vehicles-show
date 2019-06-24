package io.github.wanmudong.vehiclesshow.vehicleInfo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/4 21:02
 * @description：二、车辆管理----驾驶行为
 */
@Data
public class DrivingBehavior {
    public static final String [] longtitude = {"117.2975866732025","117.29634212821959","117.29415344566344","117.29179310173033","117.2895185884857"};
    public static final String [] altitude = {"31.848291629228918","31.84810935722912","31.848036448328415","31.84805467555907","31.847890630353984"};
    /**
     * 用户活动区域  根据所在地区返回五个经纬度坐标
     */
    private List<String[] >userActivityArea;
    /**
     * 用户活动里程
     */
    private List<Integer> userActivityMiles;
    /**
     * 用户画像
     */
    private User user;
    /**
     * 不良驾驶频次
     * 1）急加速；2）急减速； 3）急转弯；4）超速次数；5）转速不匹配；6）故障行 驶；7）长怠速次数。
     */
    private List<Integer> badDrivingFrequency;
    /**
     * 不良操作的速度分布
     * ：1）急加速；2） 急减速；3）急转弯
     *
     * 包含的Map中key为速度，value为次数
     */
    private Map<Integer,Map> speedDistributionOfBadOperation;
    /**
     * 用户出行时间分布
     */
    private Map<Integer,Integer> userTravelTimeDistribution;
    /**
     * 用户驾驶速度
     */
    private Map<Integer,int[]> userDrivingSpeed;
    /**
     * 驾驶行为评价
     */
    private DrivingBehaviorEvaluation drivingBehaviorEvaluation;

    private static final Integer AREA_NUM = 5;



    public static DrivingBehavior getRandom(VehicleInfo vehicleInfo){
        DrivingBehavior drivingBehavior = new DrivingBehavior();
        Random random = new Random();

        List<String []  > userActivityArea = new ArrayList<>();
        for (int i = 0; i < AREA_NUM; i++) {
            String [] areaArr = {longtitude[i],altitude[i]};
            userActivityArea.add(areaArr);
        }
        drivingBehavior.setUserActivityArea(userActivityArea);

        List<Integer> userActivityMiles = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            int currentMile = 120 + random.nextInt(50);
            userActivityMiles.add(currentMile);
        }
        drivingBehavior.setUserActivityMiles(userActivityMiles);

        User user = new User(vehicleInfo) ;
        drivingBehavior.setUser(user);

        Map<Integer,Map> speedDistributionOfBadOperation = new ConcurrentHashMap<>();
        int [] totalNums = new int[3];
        for (int i = 0; i < 3 ; i++) {
            Map<Integer,Integer> numOfSpeedMap = new ConcurrentHashMap<>();
            int totalNum = 0;
            for (int j = 1; j < 8; j++) {
                int numOfSpeed = random.nextInt(5);
                numOfSpeedMap.put(j*10,numOfSpeed);
                totalNum +=numOfSpeed;
            }
            totalNums[i] = totalNum;
            speedDistributionOfBadOperation.put(i,numOfSpeedMap);
        }
        drivingBehavior.setSpeedDistributionOfBadOperation(speedDistributionOfBadOperation);

        List<Integer> badDrivingFrequency = new ArrayList<>();
        for (int i = 0; i < totalNums.length; i++) {
            badDrivingFrequency.add(totalNums[i]);
        }
        for (int i = 0; i < 7 - totalNums.length; i++) {
            badDrivingFrequency.add(10+random.nextInt(10));
        }
        drivingBehavior.setBadDrivingFrequency(badDrivingFrequency);

        Map<Integer,Integer> userTravelTimeDistribution = new ConcurrentHashMap<>(24);
        for (int i = 0; i < 24; i++) {
            int travelNum = 5 + random.nextInt(5);
            userTravelTimeDistribution.put(i+1,travelNum);
        }
        drivingBehavior.setUserTravelTimeDistribution(userTravelTimeDistribution);

        Map<Integer,int[]> userDrivingSpeed = new ConcurrentHashMap<>(24);
        for (int i = 0; i < 24; i++) {
            if(i>22 || i<6){
                int [] speedArr = {0,0};
                userDrivingSpeed.put(i+1,speedArr);
            }
            int maxSpeed = 70 + random.nextInt(20);
            int averageSpeed = 50 + random.nextInt(20);
            int [] speedArr = {maxSpeed,averageSpeed};
            userDrivingSpeed.put(i+1,speedArr);
        }
        drivingBehavior.setUserDrivingSpeed(userDrivingSpeed);

        DrivingBehaviorEvaluation drivingBehaviorEvaluation = DrivingBehaviorEvaluation.getRandom(vehicleInfo);
        drivingBehavior.setDrivingBehaviorEvaluation(drivingBehaviorEvaluation);

        return drivingBehavior;

    }

}
@Data
 class User {
    private int age;
    private String sex;
    private String birthplace;
     public User(VehicleInfo vehicleInfo) {
         Random random = new Random();
         age= 20 + random.nextInt(5);
         sex = random.nextInt(2) == 0 ? "女":"男";
         birthplace = vehicleInfo.getArea();
     }
 }
@Data
 class DrivingBehaviorEvaluation {
     /**
      * 1）安全性；2）经济性；3）车辆健康；4）操作规范；5）驾驶经验；
      */
     private Integer safety;
     private Integer economic;
     private Integer vehicleHealth;
     private Integer operatingSpecification;
     private Integer drivingExperience;
    /**
     * 评分依据
     */
    private String ratingBasis;
    /**
     * 评分等级
     */
    private Integer ratingLevel;
    /**
     * 驾驶风格
     */
    private String drivingStyle;
    /**
     * 驾驶建议
     */
    private String drivingAdvice;


     public static DrivingBehaviorEvaluation getRandom(VehicleInfo vehicleInfo) {
         DrivingBehaviorEvaluation drivingBehaviorEvaluation = new DrivingBehaviorEvaluation();
         Random random = new Random();
          Integer safety = 80 + random.nextInt(15);
          Integer economic = 80 + random.nextInt(15);
          Integer vehicleHealth = 80 + random.nextInt(15);
          Integer operatingSpecification = 80 + random.nextInt(15);
          Integer drivingExperience = 80 + random.nextInt(15);
         drivingBehaviorEvaluation.setSafety(safety);
         drivingBehaviorEvaluation.setEconomic(economic);
         drivingBehaviorEvaluation.setVehicleHealth(vehicleHealth);
         drivingBehaviorEvaluation.setOperatingSpecification(operatingSpecification);
         drivingBehaviorEvaluation.setDrivingExperience(drivingExperience);

         String ratingBasis = "喜欢急刹车、急转弯，不利于驾驶安全";
         Integer ratingLevel = 3;
         String drivingStyle = "冲动型";
         String drivingAdvice = "减少急刹车！注意跟车距离";
         drivingBehaviorEvaluation.setRatingBasis(ratingBasis);
         drivingBehaviorEvaluation.setRatingLevel(ratingLevel);
         drivingBehaviorEvaluation.setDrivingStyle(drivingStyle);
         drivingBehaviorEvaluation.setDrivingAdvice(drivingAdvice);

         return drivingBehaviorEvaluation;
     }
 }