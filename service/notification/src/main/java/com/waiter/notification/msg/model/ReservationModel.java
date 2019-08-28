package com.waiter.notification.msg.model;

import lombok.Data;

@Data
public class ReservationModel {
    private Long id;
    private Long storeId;
    private String userName;
    private String reservationDate;
    private Integer userCount;
    private String contactNumber;
    private String message;
}