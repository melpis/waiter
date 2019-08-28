package com.waiter.reservation.msa.noti;

import com.waiter.reservation.model.ReservationModel;
import lombok.Data;

@Data
public class NotificationModel {

    public NotificationModel(){
        super();
    }

    public NotificationModel(ReservationModel reservationModel){
        this.storeId = reservationModel.getStoreId() ;
        this.reservationId  = reservationModel.getId();
    }

    private Long storeId;
    private Long reservationId;
    private String  message ;
    private String recvNumber;
}
