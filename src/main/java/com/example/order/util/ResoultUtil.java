package com.example.order.util;

import com.example.order.dto.Resoult;
import com.example.order.enums.exceptionEnum;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 16:54
 * @description：
 */
public class ResoultUtil {

    //成功
    public static Resoult success(Object data){
        Resoult resoult=new Resoult();
        resoult.setCode(200);
        resoult.setMsg("成功");
        resoult.setData(data);
        return resoult;
    }

    public static Resoult success(){
        return success(null);
    }

    //失败
    public static Resoult error(Integer code,String msg){
        Resoult resoult=new Resoult();
        resoult.setCode(code);
        resoult.setMsg(msg);
        return resoult;
    }

    public static Resoult error(exceptionEnum emuns){
        return error(emuns.getCode(),emuns.getMsg());
    }
}
