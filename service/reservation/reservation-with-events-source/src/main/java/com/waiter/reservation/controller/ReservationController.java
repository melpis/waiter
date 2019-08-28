package com.waiter.reservation.controller;

import com.waiter.reservation.model.ReservationModel;
import com.waiter.reservation.service.ReservationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final @NonNull
    ReservationService reservationService;

    @PostMapping("/post")
    public Mono<ReservationModel> mainController(@RequestBody ReservationModel model) {
        return reservationService.post(model);
    }

    @PutMapping("{id}")
    public Mono<ReservationModel> acceptReservation(@PathVariable Long id) {
        return reservationService.accept(id);
    }

    @DeleteMapping("{id}")
    public Mono<ReservationModel> rejectReservation(@PathVariable Long id) {
        return reservationService.reject(id);
    }
}
