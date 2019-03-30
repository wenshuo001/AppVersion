package com.ws.appversion.frgment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ws.appversion.R

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
abstract class AppVersionFragment :Fragment() {

    var fragmentview: View? =null
    var recyc : RecyclerView? =null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentview= inflater.inflate(R.layout.fragment_list, container, false);
        recyc = fragmentview!!.findViewById(R.id.rv)
        initView()
        return fragmentview

    }

    fun initView(){

    }
}