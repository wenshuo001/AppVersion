package com.ws.appversion.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.ws.appversion.R;
import com.ws.appversion.ui.GlideCircleTransformWithBorder;

public class GliedUtil {

    /**
     * 加载圆形图片
     * 边框
     * 边框颜色
     */
    public static void loadCircleCrop(Context context, String url, ImageView imageView){
        RequestOptions options = RequestOptions.bitmapTransform(new CircleCrop());
        options.placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).transform(new GlideCircleTransformWithBorder(context, 1,0xff6FD2FF));

        Glide.with(context).load(url)
                .apply(options)
                .into(imageView);
    }

}
