package com.ws.appversion.base;

import com.ws.appversion.base.BaseBean;

import java.io.Serializable;

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
public class BaseResponseBean implements Serializable {
    private static final long serialVersionUID = -1477609349345966116L;

    private int code;
    private String msg;

    public BaseBean toResponseBean() {
        BaseBean responseBean = new BaseBean();
        responseBean.code = code;
        responseBean.msg = msg;
        return responseBean;
    }
}
