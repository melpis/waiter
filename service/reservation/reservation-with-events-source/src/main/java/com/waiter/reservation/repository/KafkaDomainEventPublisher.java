package com.waiter.reservation.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.waiter.reservation.model.DomainEvent;
import com.waiter.reservation.model.DomainEventPublisher;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class KafkaDomainEventPublisher implements DomainEventPublisher {

    private final @NonNull
    Source source;
    private final @NonNull
    DomainEventsStorage domainEventStorage;
    private final @NonNull
    ObjectMapper objectMapper;


    @Override
    public void publish(DomainEvent domainEvent) {
        try {
            domainEventStorage.save(new StoredDomainEvent(objectMapper.writeValueAsString(domainEvent), domainEvent.getType()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Scheduled(fixedRate = 2000)
    @Transactional
    public void publishExternally() {
        domainEventStorage
                .findAllBySentOrderByEventTimestampDesc(false)
                .forEach(event -> {
                            Map<String, Object> headers = new HashMap<>();
                            headers.put("type", event.getEventType());
                            source.output().send(new GenericMessage<>(event.getContent(), headers));
                            event.sent();
                        }

                );
    }
}
