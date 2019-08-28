package com.waiter.reservation.service;

import com.waiter.reservation.converter.BaseConverter;
import com.waiter.reservation.domain.Reservation;
import com.waiter.reservation.domain.Reservation.ReservationStatus;
import com.waiter.reservation.model.DomainEventPublisher;
import com.waiter.reservation.model.ReservationModel;
import com.waiter.reservation.msa.noti.NotiReqMsg;
import com.waiter.reservation.msa.noti.NotificationApi;
import com.waiter.reservation.repository.ReservationRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final @NonNull
    ReservationRepository reservationRepository;

    private final @NonNull
    BaseConverter baseConverter;

    private final @NonNull
    NotificationApi notificationApi;

    private final @NonNull
    DomainEventPublisher domainEventPublisher;


    @Override
    public Mono<ReservationModel> post(ReservationModel requestModel) {

        Reservation entity = this.reservationRepository.save(this.baseConverter.convert(requestModel, Reservation.class));
        NotiReqMsg notiReqMsg = new NotiReqMsg(entity.getId(), entity.getStoreId(), NotiReqMsg.NotiType.RESERVATION_WAIT);
        this.notificationApi.sendNotification(notiReqMsg);
        this.domainEventPublisher.publish(entity);
        return Mono.just(this.baseConverter.convert(entity, ReservationModel.class));
    }

    private ReservationModel updateReservationStatus(Long id, ReservationStatus reservationStatus) {
        Reservation entity = this.reservationRepository.findById(id).get();
        entity.updateReservationStatus(reservationStatus);
        entity = this.reservationRepository.save(entity);

        ReservationModel reservationModel = this.baseConverter.convert(entity, ReservationModel.class);

        NotiReqMsg notiReqMsg = new NotiReqMsg(id, reservationModel.getStoreId(),
                reservationStatus.equals(ReservationStatus.ACCEPT) ?
                        NotiReqMsg.NotiType.RESERVATION_ACCEPT : NotiReqMsg.NotiType.RESERVATION_REJECT);

        this.notificationApi.sendNotification(notiReqMsg);
        this.domainEventPublisher.publish(entity);
        return reservationModel;
    }

    @Override
    public Mono<ReservationModel> accept(Long id) {
        return Mono.just(this.updateReservationStatus(id, ReservationStatus.ACCEPT));
    }

    @Override
    public Mono<ReservationModel> reject(Long id) {
        return Mono.just(this.updateReservationStatus(id, ReservationStatus.REJECT));
    }
}
