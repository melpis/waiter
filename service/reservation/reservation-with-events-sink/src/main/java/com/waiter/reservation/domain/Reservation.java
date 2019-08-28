package com.waiter.reservation.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
@Data
@RequiredArgsConstructor
public class Reservation  {
    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Long storeId;
    private String userName;
    private String reservationDate;
    private Integer userCount;
    private String contactNumber;

    private ReservationStatus reservationStatus;


    public enum ReservationStatus {
        ACCEPT, REJECT, WAIT
    }

    private String message;



    public void updateReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

}
