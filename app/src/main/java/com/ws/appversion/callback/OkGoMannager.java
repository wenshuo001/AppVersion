package com.ws.appversion.callback;


import android.content.SharedPreferences;
import android.util.Log;
import android.webkit.DownloadListener;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.ws.appversion.util.Convert;

import java.io.File;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;



public class OkGoMannager {
    private static String spm;
    private static String token;

    /**
     *
     * @param url
     * @param tag
     * @param map
     * @param callback
     * @param <T>
     */
    public static <T> void getRequets(String url, Object tag, Map<String, String> map, JsonCallback<T> callback) {
        // TODO:  加密 时间戳等 请求日志打印
        Log.d("OkGoMannager", "method get");
        map.put("token",token);
        OkGo.<T>get(url)
                .tag(tag)
                .params(map)
                .execute(callback);
        Log.e("Requets", "url-- "+url );
    }
    public static <T> void postRequest(String url, Object tag, Map map, JsonCallback<T> callback) {
        // TODO:  加密 时间戳等 请求日志打印

        map.put("token",token);
        OkGo.<T>post(url)
                .tag(tag)
                .params("data", mapToDESStr(map))
                .execute(callback);
        Log.e("Requets", "url-- "+url );
    }


    public static String mapToDESStr(Map data) {
        String desStr = null;
        if(data != null){
            String json = Convert.toJson(data);
            Log.e("data", "mapToDESStr--: "+json );
            desStr = json;
            try {
                //desStr = DES.encrypt(json, ENConstanValue.DES_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.e("data", "data-- "+desStr );
        return desStr;
    }
    /**
     * 下载文件
     * @param url 下载地址
     */
//    public static void downLoad(String url, DownloadListener listener, String fileNmae){
//        GetRequest<File> request = OkGo.<File>get(url);
//        DownloadTask task = OkDownload.request("a",request).save().register(listener);
//        task.folder("/mnt/sdcard/hanxunbao");
//        task.fileName(fileNmae);
//        task.start();
//    }

}
