package com.ws.appversion.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ws.appversion.R;
import com.ws.appversion.bean.AppVersionBean;
import com.ws.appversion.util.GliedUtil;

import java.util.List;

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
public class AppVersionAdapter extends BaseQuickAdapter<AppVersionBean.DataBean, BaseViewHolder> {

    public AppVersionAdapter() {
        super(R.layout.item_app_version_info);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppVersionBean.DataBean item) {
        helper.setText(R.id.app_name,item.getAppName());
        helper.setText(R.id.app_version,"版本名："+item.getAppVersionName());
        helper.setText(R.id.app_uploadTime,""+item.getAppUploadtime());
        GliedUtil.loadCircleCrop(mContext,item.getAppImg(), (ImageView) helper.getView(R.id.app_img));

    }
}