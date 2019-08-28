package com.waiter.reservation.model;

public interface DomainEventPublisher {

    void publish(DomainEvent event);

}
