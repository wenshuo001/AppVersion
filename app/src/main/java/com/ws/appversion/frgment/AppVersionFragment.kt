package com.ws.appversion.frgment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ws.appversion.R
import com.ws.appversion.base.BaseActivityCallBack
import com.ws.appversion.bean.AppVersionBean
import com.ws.appversion.middle.AppVersionInfoMiddle
import com.ws.appversion.util.Convert
import com.ws.appversion.util.JSONUtils
import com.ws.appversion.util.LogUtils

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
 class AppVersionFragment :Fragment() ,BaseActivityCallBack{

    var fragmentview: View? =null
    var recyc : RecyclerView? =null
    var appinfo : AppVersionBean? =null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentview= inflater.inflate(R.layout.fragment_list, container, false);
        recyc = fragmentview?.findViewById(R.id.rv)
        initView()
        return fragmentview

    }

    fun initView(){
         AppVersionInfoMiddle(this).getAppVersionInfo(1,1)
    }

    override fun onSuccess(any: Any) {
         if (any is AppVersionBean){
             appinfo = any as AppVersionBean
             if (appinfo?.data!=null){
                  LogUtils.debug(JSONUtils.getJson(appinfo))
             }
         }
    }

    override fun onFail(msg: String) {

    }
}