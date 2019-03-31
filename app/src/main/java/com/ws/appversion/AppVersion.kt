package com.ws.appversion

import android.app.Application
import android.os.Environment
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheEntity
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.interceptor.HttpLoggingInterceptor
import com.lzy.okserver.OkDownload
import com.lzy.okserver.task.XExecutor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
class AppVersion :Application(){


    override fun onCreate() {
        super.onCreate()
        initOKGo()
        initDownload()
    }



    private var download: OkDownload?=null
    private fun initDownload() {
        download = OkDownload.getInstance()
        val path = Environment.getExternalStorageDirectory().path+"/AppVersion"
        download?.folder=path
        download?.threadPool?.setCorePoolSize(3)
    }

    private fun initOKGo() {

        val builder = OkHttpClient.Builder()
        //使用sp保持cookie，如果cookie不过期，则一直有效
        //builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));
        val loggingInterceptor = HttpLoggingInterceptor("AppVersionHttp")
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY)
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO)
        builder.addInterceptor(loggingInterceptor)
//        builder.addInterceptor(new TokenInterceptor());
        //超时时间设置，默认60秒
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)      //全局的读取超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)     //全局的写入超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)   //全局的连接超时时间
        OkGo.getInstance()
                .init(this)
                .setOkHttpClient(builder.build()) //设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.NO_CACHE)
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE).retryCount = 3

    }

}