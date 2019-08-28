package com.waiter.store.store.model;


public class StoreModel {

    private static final long serialVersionUID = 1L;

    private long id;

    private String storeName;

    private String addr;

    private String telNum;

    private String openTime; // HH: mm

    private String closeTime;

    private String waitStartTime;

    private String waitEndTime;

    private int estimatedMinute;

    private String description;

    public StoreModel() {
        super();
    }

    public StoreModel(long id, String storeName, String addr, String telNum, String openTime, String closeTime,
            String waitStartTime, String waitEndTime, int estimatedMinute, String description) {
        super();
        this.id = id;
        this.storeName = storeName;
        this.addr = addr;
        this.telNum = telNum;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.waitStartTime = waitStartTime;
        this.waitEndTime = waitEndTime;
        this.estimatedMinute = estimatedMinute;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getWaitStartTime() {
        return waitStartTime;
    }

    public void setWaitStartTime(String waitStartTime) {
        this.waitStartTime = waitStartTime;
    }

    public String getWaitEndTime() {
        return waitEndTime;
    }

    public void setWaitEndTime(String waitEndTime) {
        this.waitEndTime = waitEndTime;
    }

    public int getEstimatedMinute() {
        return estimatedMinute;
    }

    public void setEstimatedMinute(int estimatedMinute) {
        this.estimatedMinute = estimatedMinute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
