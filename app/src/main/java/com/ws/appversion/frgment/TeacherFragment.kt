package com.ws.appversion.frgment

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.lzy.okgo.OkGo
import com.lzy.okserver.OkDownload
import com.lzy.okserver.task.XExecutor
import com.ws.appversion.Constant
import com.ws.appversion.MainActivity
import com.ws.appversion.R
import com.ws.appversion.adapter.AppVersionAdapter
import com.ws.appversion.base.BaseActivityCallBack
import com.ws.appversion.base.BaseFragment
import com.ws.appversion.bean.AppVersionBean
import com.ws.appversion.callback.LogDownloadListener
import com.ws.appversion.middle.AppVersionInfoMiddle
import com.ws.appversion.util.Convert
import com.ws.appversion.util.JSONUtils
import com.ws.appversion.util.LogUtils
import com.ws.appversion.util.ToastUtil
import kotlinx.android.synthetic.main.fragment_list.*
import java.io.File

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
 class TeacherFragment : BaseFragment() ,BaseActivityCallBack, XExecutor.OnAllTaskEndListener{

    var fragmentview: View? =null
    var recyc : RecyclerView? =null
    var mNextRequestPage=1;
    var download: OkDownload?=null
    var swipeLayout: SwipeRefreshLayout?=null

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentview= inflater?.inflate(R.layout.fragment_list, container, false)
        initView()
        return fragmentview
    }

    override fun initData() {
        initAdapter()
        refresh()
    }


    fun initView(){
        download= OkDownload.getInstance()
        download?.addOnAllTaskEndListener(this)
        recyc = fragmentview?.findViewById(R.id.rv)
        swipeLayout = fragmentview?.findViewById(R.id.swipeLayout)
    }

    var appVersionInfoAdapter : AppVersionAdapter? = null
    fun initAdapter(){
        swipeLayout?.setRefreshing(true)
        swipeLayout?.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener { refresh() })
        swipeLayout?.setColorSchemeColors(Color.rgb(47, 223, 189))
        appVersionInfoAdapter= AppVersionAdapter()
        appVersionInfoAdapter?.setOnLoadMoreListener {
            loadMore()
        }
        recyc?.setLayoutManager(LinearLayoutManager(activity))
        appVersionInfoAdapter?.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT)
        recyc?.adapter=appVersionInfoAdapter
        appVersionInfoAdapter?.setOnItemClickListener { adapter, view, position ->
             //传入下载地址
            val request = OkGo.get<File>((adapter.data[position] as AppVersionBean.DataBean).appDownloadPath)//
            //这里第一个参数是tag，代表下载任务的唯一标识，传任意字符串都行，需要保证唯一,我这里用url作为了tag
            OkDownload.request((adapter.data[position] as AppVersionBean.DataBean).appDownloadPath, request)//
                    .priority(1)//
                    .extra1((adapter.data[position] as AppVersionBean.DataBean))// 这里传入实体类 然后会在下载中去除
                    .save() //
                    .register(LogDownloadListener(activity))//
                    .start()
            ToastUtil.show(activity,"慢慢等")
        }
    }

    private fun refresh(){
        mNextRequestPage = 1
        appVersionInfoAdapter?.setEnableLoadMore(false)//这里的作用是防止下拉刷新的时候还可以上拉加载
        AppVersionInfoMiddle(this).getAppVersionInfo( (activity as MainActivity).releaseOrdebug,1)
    }

    private fun loadMore() {

    }


    private fun setData(isRefresh: Boolean, data: MutableList<AppVersionBean.DataBean>) {
        mNextRequestPage++
        val size = data?.size ?: 0
        if (isRefresh) {
            appVersionInfoAdapter?.setNewData(data)
            //appVersionInfoAdapter?.setEnableLoadMore(true)
            swipeLayout?.setRefreshing(false)
        } else {
            if (size > 0) {
                appVersionInfoAdapter?.addData(data)
            }
        }
        if (size < Constant.PAGE_SIZE) {
            //第一页如果不够一页就不显示没有更多数据布局
            appVersionInfoAdapter?.loadMoreEnd(isRefresh)
        } else {
            appVersionInfoAdapter?.loadMoreComplete()
        }
    }


    override fun onSuccess(any: Any) {
         if (any is AppVersionBean){
             if (any?.data!=null){
                 setData(true, any.data)
             }
         }
    }

    override fun onFail(msg: String) {

    }

    override fun onAllTaskEnd() {
        Snackbar.make(frafment_snake,"所有任务下载完成",Snackbar.LENGTH_SHORT).show()
    }

}