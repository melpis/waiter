package com.waiter.reservation.msa.noti;

import com.waiter.reservation.common.RestRequest;
import com.waiter.reservation.config.ReservationConfig;
import com.waiter.reservation.controller.ReservationController;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationApi {

    private final @NonNull
    RestRequest restRequest;

    private final ReservationConfig reservationConfig;

    public void sendNotification(NotiReqMsg notiReqMsg) {
        log.info("noti send : " + notiReqMsg.toString());
        this.restRequest.commonRestApiCall(this.reservationConfig.getGateWayUrl() + "/api/notification", notiReqMsg, HttpMethod.POST, null, null).subscribe();
    }

}
