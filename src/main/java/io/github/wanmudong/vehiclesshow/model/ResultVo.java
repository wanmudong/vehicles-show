package io.github.wanmudong.vehiclesshow.model;


import lombok.Data;

@Data
public class ResultVo {
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

    public static ResultVo success(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(true);
        resultVo.setLogin(true);
        resultVo.setData(data);
        return resultVo;
    }
}
