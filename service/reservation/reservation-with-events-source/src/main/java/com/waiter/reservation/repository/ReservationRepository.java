package com.waiter.reservation.repository;

import com.waiter.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByStoreIdAndReservationStatus(Long storeId, Reservation.ReservationStatus reservationStatus);

}
