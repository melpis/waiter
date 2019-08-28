package com.watier.bot.core.content.botmenu.waiting.child;


import com.watier.bot.core.content.botmenu.waiting.child.child.WatingConfirmServiceImpl;
import com.watier.bot.core.content.botmenu.waiting.child.type.ReservationAccept;
import com.watier.bot.core.content.service.BotMenuService;
import com.watier.bot.core.model.BotButtons;
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
public class WatingDetailServiceImpl implements BotMenuService {

    private final @NonNull
    WatingConfirmServiceImpl watingConfirmService;

    private final @NonNull
    ReservationApi reservationApi;

    @Override
    public BotResponseMessage contentProcess(BotRequestMessage requestMessage, String lastContext, List<String> contexts, KakaoUser kakaoUser) {
        BotResponseMessage res = new BotResponseMessage();
        BotButtons buttons = new BotButtons();
        buttons.addButton(ReservationAccept.getAllStrs());

        ReservationModel model = this.reservationApi.getReservation(requestMessage.getReservationId(null));

        res.setKeyboard(buttons);
        res.setMessage(new BotTextField(model.getDetailMessgae()));

        return res;
    }

    @Override
    public BotMenu myMenu() {
        return null;
    }

    @Override
    public BotMenuService getChildService() {
        return this.watingConfirmService;
    }
}
