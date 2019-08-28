package com.waiter.notification.msa.reservation;

import com.waiter.notification.common.RestRequest;
import com.waiter.notification.config.NotificationConfig;
import com.waiter.notification.msg.model.ReservationModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReservationApi {

    private final @NonNull
    RestRequest restRequest;

    private final NotificationConfig notificationConfig;

    public ReservationModel getResrevationInfo(Long id) {
        return this.restRequest.commonRestApiCall(this.getUrl("/"+ id), null,
                HttpMethod.GET, null, null, ReservationModel.class);
    }

    public String getUrl(String url) {
        String restUrl = this.notificationConfig.getGateWayUrl() + "/api/reservation";
        restUrl += url;
        log.info("request Url  : " + restUrl);
        return restUrl ;
    }

}
