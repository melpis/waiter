package com.waiter.reservation.domain;

import com.waiter.reservation.model.DomainEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Reservation extends BaseEntity implements DomainEvent {

    private Long storeId;
    private String userName;
    private String reservationDate;
    private Integer userCount;
    private String contactNumber;

    private ReservationStatus reservationStatus;

    @Override
    public String getType() {
        return "reservation";
    }

    public enum ReservationStatus {
        ACCEPT, REJECT, WAIT
    }

    @Column(columnDefinition = "TEXT")
    private String message;

    public Reservation() {
        this.reservationStatus = ReservationStatus.WAIT;
    }


    public void updateReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

}
