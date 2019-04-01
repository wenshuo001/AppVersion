package com.ws.appversion.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Eo_ApkDownloadInfo {
    @Id(autoincrement = true)
    private Long id;

    private Long apkid;
    private String appFilePath;
    private String app_name;
    private String app_img;
    private String app_download_path;
    private int app_is_beta;
    private int app_isPorT;
    private String app_downloadTime;
    private String app_version_code;
    @Generated(hash = 2137479045)
    public Eo_ApkDownloadInfo(Long id, Long apkid, String appFilePath,
            String app_name, String app_img, String app_download_path,
            int app_is_beta, int app_isPorT, String app_downloadTime,
            String app_version_code) {
        this.id = id;
        this.apkid = apkid;
        this.appFilePath = appFilePath;
        this.app_name = app_name;
        this.app_img = app_img;
        this.app_download_path = app_download_path;
        this.app_is_beta = app_is_beta;
        this.app_isPorT = app_isPorT;
        this.app_downloadTime = app_downloadTime;
        this.app_version_code = app_version_code;
    }
    @Generated(hash = 556487037)
    public Eo_ApkDownloadInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getApkid() {
        return this.apkid;
    }
    public void setApkid(Long apkid) {
        this.apkid = apkid;
    }
    public String getAppFilePath() {
        return this.appFilePath;
    }
    public void setAppFilePath(String appFilePath) {
        this.appFilePath = appFilePath;
    }
    public String getApp_name() {
        return this.app_name;
    }
    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }
    public String getApp_img() {
        return this.app_img;
    }
    public void setApp_img(String app_img) {
        this.app_img = app_img;
    }
    public String getApp_download_path() {
        return this.app_download_path;
    }
    public void setApp_download_path(String app_download_path) {
        this.app_download_path = app_download_path;
    }
    public int getApp_is_beta() {
        return this.app_is_beta;
    }
    public void setApp_is_beta(int app_is_beta) {
        this.app_is_beta = app_is_beta;
    }
    public int getApp_isPorT() {
        return this.app_isPorT;
    }
    public void setApp_isPorT(int app_isPorT) {
        this.app_isPorT = app_isPorT;
    }
    public String getApp_downloadTime() {
        return this.app_downloadTime;
    }
    public void setApp_downloadTime(String app_downloadTime) {
        this.app_downloadTime = app_downloadTime;
    }
    public String getApp_version_code() {
        return this.app_version_code;
    }
    public void setApp_version_code(String app_version_code) {
        this.app_version_code = app_version_code;
    }
}
