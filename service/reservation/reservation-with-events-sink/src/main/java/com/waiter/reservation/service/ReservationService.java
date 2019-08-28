package com.waiter.reservation.service;

import com.waiter.reservation.model.ReservationModel;
import com.waiter.reservation.model.ReservationSearchKey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReservationService {

    Mono<ReservationModel> findOne(Long id);

    Flux<ReservationModel> getWaitingList(ReservationSearchKey key);

    Flux<ReservationModel> getReservationList(ReservationSearchKey key);
}
