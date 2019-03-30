package com.ws.appversion.exception;

import com.ws.appversion.base.BaseResponseBean;
import com.ws.appversion.util.Convert;

/**
 * Created by 夏彪 on 2017/12/7.
 */

public class AppVersionException extends IllegalStateException {

    private BaseResponseBean errorBean;

    public AppVersionException(String s) {
        super(s);
        errorBean = Convert.fromJson(s, BaseResponseBean.class);
    }

    public BaseResponseBean getErrorBean() {
        return errorBean;
    }
}
