package com.ws.appversion.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2018/5/28 0028.
 */

public class JSONUtils {

    /**
     * 把Java对象转换为JSON数据格式
     *
     * @param object
     * @return
     */
    public static String getJson(Object object) {
        try {
//            return JSON.toJSONString(object);
            return JSON.toJSONString(object);
        } catch (Exception e) {
            // logger.error("[JsonUtils]Fail to getjson", e);
        }
        return null;
    }

    /**
     * 把JSON数据格式转换为JAVA对象
     *
     * @param <T>
     * @param jsonData
     * @param clz
     * @return
     */
    public static <T> T readValue(String jsonData, Class<T> clz) {
        try {
            return JSON.parseObject(jsonData, clz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
