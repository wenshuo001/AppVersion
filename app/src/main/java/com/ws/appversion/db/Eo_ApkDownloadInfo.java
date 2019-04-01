package com.ws.appversion.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Eo_ApkDownloadInfo {
    @Id(autoincrement = true)
    Long apkid;
    String appFilePath;
    private String app_name;
    private String app_img;
    private String app_download_path;
    private int app_is_beta;
    private int app_isPorT;
    private String app_downloadTime;
    private String app_version_code;
}
