package com.ws.appversion.middle

import com.ws.appversion.Constant
import com.ws.appversion.base.BaseActivityCallBack
import com.ws.appversion.base.BaseMiddle
import com.ws.appversion.bean.AppVersionBean
import java.util.HashMap

/**
 * Creator :Wen
 * DataTime: 2019/3/31
 * Description:
 */
class AppVersionInfoMiddle(activity: BaseActivityCallBack) : BaseMiddle(activity) {


    /**
     * app_is_beta = 0 测试服 1 正式服
     * app_isPorT = 0 家长 1 教师
     */
    fun getAppVersionInfo(app_is_beta: Int, app_isPorT: Int) {
        val data = HashMap<String,String>()
        data.put("app_is_beta", app_is_beta.toString())
        data.put("app_isPorT", app_isPorT.toString())
        sendGet("http://192.168.0.102:8099/app_version", data, AppVersionBean())
    }


}