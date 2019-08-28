package com.waiter.notification.service;

import com.waiter.notification.controller.msg.NotiReqMsg;

import java.util.concurrent.CompletableFuture;

public interface NotificationService {

    CompletableFuture<Boolean> sendNotification(NotiReqMsg notiReqMsg);
}
