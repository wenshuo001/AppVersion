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
    fun getHomeWorkList(app_is_beta: String, app_isPorT: String) {
        val data = HashMap<String,Any>()
        data.put("app_is_beta", app_is_beta)
        data.put("app_isPorT", app_isPorT)

        send(Constant.REQUEST_BASE_URL+Constant.TODO_STATUS_ADD, data, AppVersionBean())
    }


}