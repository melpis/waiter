package com.watier.bot.core.content.botmenu.status;

import com.watier.bot.core.content.component.ContentComponent;
import com.watier.bot.core.content.service.BotMenuService;
import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import com.watier.bot.core.type.BotMenu;
import com.watier.bot.msa.reservation.ReservationApi;
import com.watier.bot.reservation.model.ReservationModel;
import com.watier.bot.user.domain.KakaoUser;
import com.watier.bot.user.repository.KakaoUserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements BotMenuService {

    private final @NonNull
    ContentComponent contentComponent;

    private final @NonNull
    ReservationApi reservationApi;

    @Override
    public BotResponseMessage contentProcess(BotRequestMessage requestMessage, String lastContext, List<String> contexts, KakaoUser kakaoUser) {
        List<ReservationModel> reservationModels = this.reservationApi.getReservationList(kakaoUser.getStoreId());
        StringBuffer strBuffer = new StringBuffer();
        reservationModels.forEach(model -> {
            strBuffer.append(model.getTitleText());
            strBuffer.append("\n");
        });

        return this.contentComponent.getBasicMessage(requestMessage, strBuffer.toString());
    }

    @Override
    public BotMenu myMenu() {
        return BotMenu.RESERVATION_LIST;
    }

    @Override
    public BotMenuService getChildService() {
        return null;
    }
}