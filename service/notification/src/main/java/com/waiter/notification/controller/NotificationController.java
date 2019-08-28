package com.waiter.notification.controller;

import com.waiter.notification.controller.msg.NotiReqMsg;
import com.waiter.notification.service.NotificationService;
import hsim.checkpoint.core.annotation.ValidationBody;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final @NonNull
    NotificationService notificationService ;

    @PostMapping("/")
    public CompletableFuture<Boolean> notificationAdmin(@ValidationBody NotiReqMsg notiReqMsg) {
        log.info(notiReqMsg.toString());
        return this.notificationService.sendNotification(notiReqMsg);
    }
}
