package com.watier.bot.reservation.model;

import com.watier.bot.common.BaseModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationModel extends BaseModel {
    private Long storeid;
    private String userName;
    private String reservationDate;
    private Integer userCount;
    private String contactNumber;
    private String message;

    public ReservationModel id(Long id) {
        this.setId(id);
        return this;
    }

    public String getDetailMessgae() {
        StringBuffer stringBuffer = new StringBuffer(this.getId() + ". ");
        stringBuffer.append("\n");
        stringBuffer.append("일시 : " + this.getReservationDate());
        stringBuffer.append("\n");
        stringBuffer.append("예약자 : " + this.getUserName());
        stringBuffer.append("\n");
        stringBuffer.append("총인원 : " + this.getUserCount());
        stringBuffer.append("\n");
        stringBuffer.append("연락처 : " + this.getContactNumber());
        stringBuffer.append("\n");
        stringBuffer.append("메세지 : " + this.getMessage());
        return stringBuffer.toString();
    }

    public String getTitleText() {
        StringBuffer stringBuffer = new StringBuffer(this.getId() + ". ");
        stringBuffer.append(this.getReservationDate());
        stringBuffer.append("(");
        stringBuffer.append(this.getUserName());
        stringBuffer.append(" 외 ");
        stringBuffer.append(this.getUserCount() - 1);
        stringBuffer.append("명");
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
