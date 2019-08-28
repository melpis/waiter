package com.waiter.notification.controller.type;

import com.waiter.notification.msg.model.ReservationModel;
import com.waiter.notification.msg.model.StoreModel;
import com.waiter.notification.util.VelocityUtil;
import lombok.Getter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;

public enum NotiType {

    RESERVATION_WAIT(NotiReceiverType.ADMIN, "[ ${reservation.reservationDate} ]\n${reservation.userName}으로부터 ${reservation.userCount}명의 예약이 신청 되었습니다."),
    RESERVATION_ACCEPT(NotiReceiverType.USER, "[ ${store.storeName} - ${reservation.reservationDate} ] 예약이 최종 수락 되었습니다."),
    RESERVATION_REJECT(NotiReceiverType.USER, "[ ${store.storeName} - ${reservation.reservationDate} ] 예약이 상점의 사정으로 인해 거절 되었습니다.");

    @Getter
    private final NotiReceiverType notiReceiverType;

    private final String notiMessage;

    NotiType(NotiReceiverType notiReceiverType, String message) {
        this.notiReceiverType = notiReceiverType;
        this.notiMessage = message;
    }

    public String getNotiMessage(ReservationModel reservation, StoreModel store) {
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("reservation", reservation);
        velocityContext.put("store", store);

        return VelocityUtil.templateMapping(this.notiMessage, velocityContext);
    }

    public String getRecvNumber(ReservationModel reservationModel, StoreModel storeModel) {
        if (this.notiReceiverType.equals(NotiReceiverType.ADMIN)) {
            return storeModel.getTelNum();
        } else {
            return reservationModel.getContactNumber();
        }
    }


}
