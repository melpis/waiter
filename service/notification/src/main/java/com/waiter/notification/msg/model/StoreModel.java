package com.waiter.notification.msg.model;

import lombok.Data;

@Data
public class StoreModel {

    private Long id;
    private String storeName;
    private String addr;
    private String telNum;
    private String openTime;
    private String closeTime;
    private String waitStartTime;
    private String waitEndTime;
    private Integer estimatedMinute;
    private String description;

}