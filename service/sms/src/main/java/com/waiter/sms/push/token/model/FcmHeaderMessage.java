package com.waiter.sms.push.token.model;

import com.waiter.sms.push.token.entity.SmsMsg;
import lombok.Data;

@Data
public class FcmHeaderMessage {
    private String to;
    private SmsMsg data;
    //private FcmNotificationMessage com.waiter.reservation.msa.notification = new FcmNotificationMessage();
}
