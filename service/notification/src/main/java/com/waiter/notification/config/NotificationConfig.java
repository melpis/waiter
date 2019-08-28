package com.waiter.notification.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NotificationConfig {

    @Value("${sms.send.number}")
    private String smsSendNumber;

    @Value("${gateway.url}")
    private String gateWayUrl;
}
