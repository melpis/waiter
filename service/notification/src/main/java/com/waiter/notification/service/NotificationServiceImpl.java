package com.waiter.notification.service;

import com.waiter.notification.config.NotificationConfig;
import com.waiter.notification.controller.NotificationController;
import com.waiter.notification.controller.msg.NotiReqMsg;
import com.waiter.notification.msa.reservation.ReservationApi;
import com.waiter.notification.msa.sms.SmsApi;
import com.waiter.notification.msa.sms.SmsMsg;
import com.waiter.notification.msa.store.StoreApi;
import com.waiter.notification.msg.model.ReservationModel;
import com.waiter.notification.msg.model.StoreModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final @NonNull
    SmsApi smsApi;

    private final @NonNull
    ReservationApi reservationApi;

    private final @NonNull
    StoreApi storeApi;

    private final @NonNull
    NotificationConfig notificationConfig;

    private ReservationModel getReservationModel(NotiReqMsg notiReqMsg) {
        return notiReqMsg.getReservationId() != null && notiReqMsg.getReservationId() > 0 ?
                this.reservationApi.getResrevationInfo(notiReqMsg.getReservationId()) : null;
    }

    private StoreModel getStoreModel(NotiReqMsg notiReqMsg) {
        return notiReqMsg.getStoreId() != null && notiReqMsg.getStoreId() > 0 ?
                this.storeApi.getSoreInfo(notiReqMsg.getStoreId()) : null;
    }

    @Override
    @Async
    public CompletableFuture<Boolean> sendNotification(NotiReqMsg notiReqMsg) {
        SmsMsg smsMsg  = notiReqMsg.getSmsMsg(
                this.notificationConfig.getSmsSendNumber(),
                this.getReservationModel(notiReqMsg), this.getStoreModel(notiReqMsg));

        boolean sendRes = this.smsApi.sendSms(smsMsg);

        return CompletableFuture.completedFuture(sendRes);
    }
}
