package com.waiter.reservation.repository;

import com.waiter.reservation.domain.Reservation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;



public interface ReservationRepository extends ReactiveCrudRepository<Reservation, Long> {

    Flux<Reservation> findByStoreIdAndReservationStatus(Long storeId, Reservation.ReservationStatus reservationStatus);

}
