package com.waiter.sms.push.token.model;

import com.waiter.sms.push.token.entity.FcmToken;
import lombok.Data;

@Data
public class FcmPushMessage {
    private FcmHeaderMessage message;

    public FcmPushMessage(FcmToken token) {
        this.message = new FcmHeaderMessage();
        this.message.setTo(token.getToken());
    }
}

