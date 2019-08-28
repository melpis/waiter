package com.waiter.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableBinding(Source.class)
@EntityScan
public class ReservationSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationSourceApplication.class, args);
    }
}
