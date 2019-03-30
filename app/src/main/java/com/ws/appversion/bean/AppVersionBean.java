package com.ws.appversion.bean;

import com.ws.appversion.base.BaseBean;

import java.util.List;

/**
 * Creator :Wen
 * DataTime: 2019/3/30
 * Description:
 */
public class AppVersionBean extends BaseBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * appName : 快乐教师
         * appImg : img
         * appDownloadPath : https
         * appIsBeta : 1
         * appIsport : 1
         * appUploadtime : 2019/3/25 11:43
         * appVersionCode : 2
         * appVersionName : 1.1.2
         */

        private int id;
        private String appName;
        private String appImg;
        private String appDownloadPath;
        private int appIsBeta;
        private int appIsport;
        private String appUploadtime;
        private String appVersionCode;
        private String appVersionName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getAppImg() {
            return appImg;
        }

        public void setAppImg(String appImg) {
            this.appImg = appImg;
        }

        public String getAppDownloadPath() {
            return appDownloadPath;
        }

        public void setAppDownloadPath(String appDownloadPath) {
            this.appDownloadPath = appDownloadPath;
        }

        public int getAppIsBeta() {
            return appIsBeta;
        }

        public void setAppIsBeta(int appIsBeta) {
            this.appIsBeta = appIsBeta;
        }

        public int getAppIsport() {
            return appIsport;
        }

        public void setAppIsport(int appIsport) {
            this.appIsport = appIsport;
        }

        public String getAppUploadtime() {
            return appUploadtime;
        }

        public void setAppUploadtime(String appUploadtime) {
            this.appUploadtime = appUploadtime;
        }

        public String getAppVersionCode() {
            return appVersionCode;
        }

        public void setAppVersionCode(String appVersionCode) {
            this.appVersionCode = appVersionCode;
        }

        public String getAppVersionName() {
            return appVersionName;
        }

        public void setAppVersionName(String appVersionName) {
            this.appVersionName = appVersionName;
        }
    }
}
