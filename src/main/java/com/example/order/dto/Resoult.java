package com.example.order.dto;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 15:48
 * @description：
 */
@Data
public class Resoult <T>{

    private Integer code;   /*正确&错误放回吗*/

    private String msg;     /*返回信息*/

    private T data;     /*请求的数据*/
}
