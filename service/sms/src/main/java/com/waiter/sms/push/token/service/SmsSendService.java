package com.waiter.sms.push.token.service;

import com.waiter.sms.push.token.entity.SmsMsg;

public interface SmsSendService {

    SmsMsg sendSms(SmsMsg smsMsg);

    void callback(Long id);
}
