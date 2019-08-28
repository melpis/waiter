package com.waiter.sms.push.token.service;

import com.waiter.sms.push.token.entity.FcmToken;

public interface FcmTokenService {

    FcmToken registFcmToken(FcmToken fcmToken);
}
