package com.waiter.reservation.service;

import com.waiter.reservation.converter.BaseConverter;
import com.waiter.reservation.domain.Reservation;
import com.waiter.reservation.model.ReservationModel;
import com.waiter.reservation.model.ReservationSearchKey;
import com.waiter.reservation.repository.ReservationRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.scheduler.Schedulers.parallel;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final @NonNull
    ReservationRepository reservationRepository;

    private final @NonNull
    BaseConverter baseConverter;


    @Override
    public Mono<ReservationModel> findOne(Long id) {
        return this.reservationRepository.findById(id).map(reservation -> this.baseConverter.convert(reservation, ReservationModel.class));
    }


    @Override
    public Flux<ReservationModel> getWaitingList(ReservationSearchKey key) {
        return this.reservationRepository.findByStoreIdAndReservationStatus(key.getStoreId(),
                Reservation.ReservationStatus.WAIT).window(3)
                .flatMapSequential(reservationFlux -> reservationFlux.map(reservation -> this.baseConverter.convert(reservation, ReservationModel.class)).subscribeOn(parallel())).log();
    }

    @Override
    public Flux<ReservationModel> getReservationList(ReservationSearchKey key) {
        return this.reservationRepository.findByStoreIdAndReservationStatus(key.getStoreId(),
                Reservation.ReservationStatus.ACCEPT).window(3)
                .flatMapSequential(reservationFlux -> reservationFlux.map(reservation -> this.baseConverter.convert(reservation, ReservationModel.class)).subscribeOn(parallel()));
    }
}
