package com.waiter.reservation.controller;

import com.waiter.reservation.model.ReservationModel;
import com.waiter.reservation.model.ReservationSearchKey;
import com.waiter.reservation.service.ReservationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final @NonNull
    ReservationService reservationService;

    @GetMapping("/reservation")
    public Flux<ReservationModel> getReservationList(@ModelAttribute ReservationSearchKey key) {
        return reservationService.getReservationList(key);
    }

    @GetMapping("/waiting")
    public Flux<ReservationModel> getWaitingReservationList(@ModelAttribute ReservationSearchKey key) {
        return reservationService.getWaitingList(key);
    }

    @GetMapping("{id}")
    public Mono<ReservationModel> findReservation(@PathVariable Long id) {
        return reservationService.findOne(id);
    }

}
