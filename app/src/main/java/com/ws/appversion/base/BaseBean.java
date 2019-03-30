package com.ws.appversion.base;

import java.io.Serializable;
import java.util.List;

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
public class BaseBean<T> implements Serializable {
    public int code;
    public String msg;
    public T data;
}
