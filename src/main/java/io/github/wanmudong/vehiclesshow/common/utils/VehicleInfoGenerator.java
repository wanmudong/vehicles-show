package io.github.wanmudong.vehiclesshow.common.utils;



import io.github.wanmudong.vehiclesshow.vehicleInfo.entity.VehicleInfo;

import java.util.Random;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/29 9:08
 * @description：用于生成数据库中的车辆信息
 * @modified By：
 * @version: 0.0.1$
 */
public class VehicleInfoGenerator {
    public  VehicleInfo generator() {

            VehicleInfo vi = new VehicleInfo();

            Random random = new Random();
            //车辆VIN号
            String vinString = "LVVDB21B8HD";
            int vinNum = 100000+ random.nextInt(250000);
            String vin = vinString+vinNum;
            //车型
            int model = random.nextInt(3);
            //车辆所在地区
            int areaNum = random.nextInt(11);
            String area="";
            if (areaNum<5){
                area = "安徽";
            }else if(areaNum<6){
                area = "浙江";
            }else if (areaNum<7){
                area = "江苏";
            }else if (areaNum<8){
                area = "上海";
            }else if (areaNum<9){
                area = "北京";
            }else {
                areaNum = random.nextInt(33);

                area = "";
            }

            //车辆是否在线
            int isOnline = random.nextInt(2);

            //驾驶风格
            int drivenStyle = random.nextInt(10);
            if (drivenStyle<2){
                drivenStyle = 0;
            }else if(drivenStyle<5){
                drivenStyle = 1;
            }else {
                drivenStyle = 3;
            }

            //故障数
            int failureNums = 30+random.nextInt(20);

            vi.setVin(vin);
            vi.setNumberOfFailures(failureNums);
            vi.setModel(model);
            vi.setDrivenStyle(drivenStyle);
            vi.setIsOnline(isOnline);
            vi.setArea(area);

            return  vi;

        }

}
