package io.github.wanmudong.vehiclesshow.model;


import lombok.Data;

@Data
public class ResultVO {
    /**
     * 处理是否成功
     */
    boolean success;
    /**
     * 用户是否登陆
     */
    boolean login;
    /**
     * 传输的数据
     */
    Object data;

    public static ResultVO success(Object data){
        ResultVO resultVo = new ResultVO();
        resultVo.setSuccess(true);
        resultVo.setLogin(true);
        resultVo.setData(data);
        return resultVo;
    }
}
