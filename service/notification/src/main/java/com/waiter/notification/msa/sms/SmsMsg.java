package com.waiter.notification.msa.sms;

import lombok.Data;

@Data
public class SmsMsg {
    private String sendNumber;
    private String recvNumber;
    private String message;
}
