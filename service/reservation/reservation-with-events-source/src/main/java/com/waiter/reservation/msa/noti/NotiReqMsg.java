package com.waiter.reservation.msa.noti;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotiReqMsg {

    private Long reservationId;
    private Long storeId;
    private NotiType notiType;

    public enum NotiType {
        RESERVATION_WAIT, RESERVATION_ACCEPT, RESERVATION_REJECT;
    }
}
