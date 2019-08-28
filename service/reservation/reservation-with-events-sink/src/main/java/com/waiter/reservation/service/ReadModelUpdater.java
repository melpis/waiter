package com.waiter.reservation.service;

import com.waiter.reservation.domain.Reservation;
import com.waiter.reservation.repository.ReservationRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class ReadModelUpdater {

	private final @NonNull ReservationRepository reservationRepository;

	@StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'reservation'")
	public void handle(Reservation reservation) {
		this.reservationRepository.save(reservation).subscribe();
	}
}
