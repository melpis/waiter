package com.waiter.notification.msa.store;

import com.waiter.notification.common.RestRequest;
import com.waiter.notification.config.NotificationConfig;
import com.waiter.notification.msg.model.StoreModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreApi {

    private final @NonNull
    RestRequest restRequest;
    private final @NonNull
    NotificationConfig notificationConfig;

    public StoreModel getSoreInfo(Long id) {
        return this.restRequest.commonRestApiCall(this.getUrl("" + id), null,
                HttpMethod.GET, null, null, StoreModel.class);
    }

    public String getUrl(String url) {
        return this.notificationConfig.getGateWayUrl() + "/api/store/" +  url;
    }

}
