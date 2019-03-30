package com.ws.appversion.base

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
interface BaseActivityCallBack {
    fun onSuccess(any: Any)
    fun onFail(msg: String)
}