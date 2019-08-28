package com.waiter.notification.controller.msg;

import com.waiter.notification.controller.type.NotiType;
import com.waiter.notification.msa.sms.SmsMsg;
import com.waiter.notification.msg.model.ReservationModel;
import com.waiter.notification.msg.model.StoreModel;
import lombok.Data;

@Data
public class NotiReqMsg {
    private Long reservationId;
    private Long storeId;
    private NotiType notiType;

    public SmsMsg getSmsMsg(String senderNumber, ReservationModel reservationModel, StoreModel storeModel){
        SmsMsg smsMsg = new SmsMsg() ;
        smsMsg.setSendNumber(senderNumber);
        smsMsg.setRecvNumber(this.notiType.getRecvNumber(reservationModel, storeModel));
        smsMsg.setMessage(this.notiType.getNotiMessage(reservationModel, storeModel));
        return smsMsg;
    }
}
