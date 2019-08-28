package com.waiter.reservation.service;

import com.waiter.reservation.model.ReservationModel;
import com.waiter.reservation.model.ReservationSearchKey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ReservationService {

    Mono<ReservationModel> post(ReservationModel requestModel);
    Mono<ReservationModel> accept(Long id);
    Mono<ReservationModel> reject(Long id);
}
