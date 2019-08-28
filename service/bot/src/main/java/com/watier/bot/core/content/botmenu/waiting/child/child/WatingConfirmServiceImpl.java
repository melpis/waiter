package com.watier.bot.core.content.botmenu.waiting.child.child;


import com.watier.bot.core.content.botmenu.waiting.child.type.ReservationAccept;
import com.watier.bot.core.content.component.ContentComponent;
import com.watier.bot.core.content.service.BotMenuService;
import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import com.watier.bot.core.model.BotTextField;
import com.watier.bot.core.type.BotMenu;
import com.watier.bot.msa.reservation.ReservationApi;
import com.watier.bot.reservation.model.ReservationModel;
import com.watier.bot.user.domain.KakaoUser;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WatingConfirmServiceImpl implements BotMenuService {

    private final @NonNull
    ContentComponent contentComponent;

    private final @NonNull
    ReservationApi reservationApi;

    @Override
    public BotResponseMessage contentProcess(BotRequestMessage requestMessage, String lastContext, List<String> contexts, KakaoUser kakaoUser) {
        assert requestMessage.getContent() != null;

        BotResponseMessage res = new BotResponseMessage();

        ReservationAccept accept = ReservationAccept.findByStr(requestMessage.getContent());
        Long reservationId = requestMessage.getReservationId(lastContext);

        if (accept.equals(ReservationAccept.ACCEPT)) {
            res.setMessage(new BotTextField("예약 되었습니다."));
            this.reservationApi.acceptReservation(reservationId);
        } else if (accept.equals(ReservationAccept.REJECT)) {
            res.setMessage(new BotTextField("예약을 거절했습니다."));
            this.reservationApi.rejectReservation(reservationId);
        }

        res.setKeyboard(this.contentComponent.getBasicMenu(requestMessage));

        return res;
    }

    @Override
    public BotMenu myMenu() {
        return null;
    }

    @Override
    public BotMenuService getChildService() {
        return null;
    }
}
