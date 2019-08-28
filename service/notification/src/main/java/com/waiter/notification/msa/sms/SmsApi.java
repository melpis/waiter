package com.waiter.notification.msa.sms;

import com.waiter.notification.common.RestRequest;
import com.waiter.notification.config.NotificationConfig;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SmsApi {

    private final @NonNull
    RestRequest restRequest;

    private final @NonNull
    NotificationConfig notificationConfig;


    private String getUrl(String url) {
        String smsUrl = this.notificationConfig.getGateWayUrl() + "/api/sms/" + url;
        return smsUrl;
    }

    public boolean sendSms(SmsMsg smsMsg) {
        ResponseEntity<String> res = this.restRequest.commonRestApiCall(this.getUrl("send"), smsMsg, HttpMethod.POST, null, null);
        return this.restRequest.isSuccess(res);
    }

}
