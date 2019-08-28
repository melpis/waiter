package com.waiter.reservation.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ReservationConfig {

    @Value("${gateway.url}")
    private String gateWayUrl;
}
