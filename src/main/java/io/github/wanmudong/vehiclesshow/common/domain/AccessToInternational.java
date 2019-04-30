package io.github.wanmudong.vehiclesshow.common.domain;

import lombok.Data;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/4/30 18:13
 * @description：接入国际
 */
@Data
public class AccessToInternational {
    private int accessToInternationalNum;
    private int accessOffInternationalNum;

    public static AccessToInternational getRandom(){
        AccessToInternational at = new AccessToInternational();

        at.setAccessOffInternationalNum(20000);
        at.setAccessToInternationalNum(13000);

        return at;
    }
}
