package com.ws.appversion.base

import android.util.Log
import com.alibaba.fastjson.JSON
import com.lzy.okgo.model.Response
import com.ws.appversion.callback.JsonCallback
import com.ws.appversion.callback.OkGoMannager
import com.ws.appversion.util.Convert
import com.ws.appversion.util.JSONUtils
import java.net.SocketException
import java.net.SocketTimeoutException

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
abstract class BaseMiddle(var activity: BaseActivityCallBack) {
    private val spm: String? = null
    private val token: String? = null


    protected fun send(url: String, data: Map<*, *>, any: Any) {
        OkGoMannager.postRequest(url, this, data, object : JsonCallback<Any>() {
            override fun onSuccess(response: Response<Any>) {
                activity.onSuccess(Convert.fromJson(JSON.toJSONString(response.body()), any.javaClass))
            }

            override fun onError(response: Response<Any>) {
                super.onError(response)
                val code = response.code()
                if (code == 404) {
                    activity.onFail("404 当前链接不存在")
                   // LogUtils.debug("404 当前链接不存在")
                }
                val exception = response.exception

                if (response.exception is SocketTimeoutException) {
                    Log.d("JsonCallback", "请求超时")
                    activity.onFail("请求超时")
                } else if (response.exception is SocketException) {
                    Log.d("JsonCallback", "服务器异常")
                    activity.onFail("服务器异常")
                } else {
                    activity.onFail("网络异常")
                }
            }
        })
    }

    protected fun sendGet(url: String, data: Map<String, String>, any: Any) {
        OkGoMannager.getSingleRequets(url, this, data, object : JsonCallback<Any>() {
            override fun onSuccess(response: Response<Any>) {
                activity.onSuccess(JSONUtils.readValue(JSON.toJSONString(response.body()), any.javaClass))
            }

            override fun onError(response: Response<Any>) {
                super.onError(response)
                val code = response.code()
                if (code == 404) {
                    activity.onFail("404 当前链接不存在")
                    // LogUtils.debug("404 当前链接不存在")
                }
                val exception = response.exception

                if (response.exception is SocketTimeoutException) {
                    Log.d("JsonCallback", "请求超时")
                    activity.onFail("请求超时")
                } else if (response.exception is SocketException) {
                    Log.d("JsonCallback", "服务器异常")
                    activity.onFail("服务器异常")
                } else {
                    activity.onFail("网络异常")
                }
            }
        })
    }


}
