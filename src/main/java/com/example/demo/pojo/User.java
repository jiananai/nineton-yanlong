package com.example.demo.pojo;

import java.util.Date;

public class User {
    private String userid;

    private Integer isFristCharge;

    private String username;

    private Date createtime;

    private Integer ifCoin1;

    private Integer ifCoin2;

    private Integer consumeCoin;

    private Integer haveCoin;

    private Double consumeMoney;

    private String packageName;

    private String platform;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getIsFristCharge() {
        return isFristCharge;
    }

    public void setIsFristCharge(Integer isFristCharge) {
        this.isFristCharge = isFristCharge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getIfCoin1() {
        return ifCoin1;
    }

    public void setIfCoin1(Integer ifCoin1) {
        this.ifCoin1 = ifCoin1;
    }

    public Integer getIfCoin2() {
        return ifCoin2;
    }

    public void setIfCoin2(Integer ifCoin2) {
        this.ifCoin2 = ifCoin2;
    }

    public Integer getConsumeCoin() {
        return consumeCoin;
    }

    public void setConsumeCoin(Integer consumeCoin) {
        this.consumeCoin = consumeCoin;
    }

    public Integer getHaveCoin() {
        return haveCoin;
    }

    public void setHaveCoin(Integer haveCoin) {
        this.haveCoin = haveCoin;
    }

    public Double getConsumeMoney() {
        return consumeMoney;
    }

    public void setConsumeMoney(Double consumeMoney) {
        this.consumeMoney = consumeMoney;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", isFristCharge=" + isFristCharge +
                ", username='" + username + '\'' +
                ", createtime=" + createtime +
                ", ifCoin1=" + ifCoin1 +
                ", ifCoin2=" + ifCoin2 +
                ", consumeCoin=" + consumeCoin +
                ", haveCoin=" + haveCoin +
                ", consumeMoney=" + consumeMoney +
                ", packageName='" + packageName + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}