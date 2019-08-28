package com.watier.bot.msa.reservation;

import com.watier.bot.common.RestRequest;
import com.watier.bot.config.BotConfig;
import com.watier.bot.reservation.model.ReservationModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReservationApi {

    private final @NonNull
    RestRequest restRequest;

    private final BotConfig botConfig;

    public void acceptReservation(Long reservationId) {
        this.restRequest.commonRestApiCall(this.botConfig.getGateWayUrl() + "/api/reservation/" + reservationId, null, HttpMethod.PUT, null, null, String.class, false);
    }

    public void rejectReservation(Long reservationId) {
        this.restRequest.commonRestApiCall(this.botConfig.getGateWayUrl() + "/api/reservation/" + reservationId, null, HttpMethod.DELETE, null, null, String.class, false);
    }

    public List<ReservationModel> getReservationList(Long storeId) {
        Object res = this.restRequest.commonRestApiCall(this.botConfig.getGateWayUrl() + "/api/reservation/reservation?storeId=" + storeId, null, HttpMethod.GET, null, null, ReservationModel.class, true);
        if (res == null) {
            return new ArrayList<>();
        }
        return (List<ReservationModel>) res;
    }

    public List<ReservationModel> getWaitingList(Long storeId) {
        Object res = this.restRequest.commonRestApiCall(this.botConfig.getGateWayUrl() + "/api/reservation/waiting?storeId=" + storeId, null, HttpMethod.GET, null, null, ReservationModel.class, true);
        if (res == null) {
            return new ArrayList<>();
        }
        return (List<ReservationModel>) res;
    }

    public ReservationModel getReservation(Long reservationId) {
        return this.restRequest.commonRestApiCall(this.botConfig.getGateWayUrl() + "/api/reservation/" + reservationId, null, HttpMethod.GET, null, null, ReservationModel.class, false);
    }
}
