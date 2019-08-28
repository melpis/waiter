package com.waiter.reservation.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
class StoredDomainEvent {

    @Id String id;
    @Column(columnDefinition = "TEXT")
    private String content;
    private boolean sent;
    private Instant eventTimestamp = Instant.now();
    private String eventType;

    StoredDomainEvent(String content, String eventType) {
        this.content = content;
        this.id = UUID.randomUUID().toString();
        this.eventType = eventType;
    }

    private StoredDomainEvent() {
    }

    void sent() {
        sent = true;
    }

    String getContent() {
        return content;
    }

    public String getEventType() {
        return eventType;
    }
}