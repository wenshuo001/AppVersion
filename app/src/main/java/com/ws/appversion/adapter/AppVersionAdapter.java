package com.ws.appversion.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ws.appversion.bean.AppVersionBean;

import java.util.List;

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
public class AppVersionAdapter extends BaseQuickAdapter<AppVersionBean.DataBean, BaseViewHolder> {

    public AppVersionAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppVersionBean.DataBean item) {


    }
}