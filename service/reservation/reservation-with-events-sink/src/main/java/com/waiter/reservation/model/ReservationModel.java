package com.waiter.reservation.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReservationModel extends BaseModel {
    private Long storeId;

    private String userName;
    private String reservationDate;
    private Integer userCount;
    private String contactNumber;
    private String message;
}
