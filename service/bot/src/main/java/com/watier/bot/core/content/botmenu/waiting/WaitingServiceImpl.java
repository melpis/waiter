package com.watier.bot.core.content.botmenu.waiting;

import com.watier.bot.core.content.botmenu.waiting.child.WatingDetailServiceImpl;
import com.watier.bot.core.content.component.ContentComponent;
import com.watier.bot.core.content.service.BotMenuService;
import com.watier.bot.core.model.BotButtons;
import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import com.watier.bot.core.model.BotTextField;
import com.watier.bot.core.type.BotMenu;
import com.watier.bot.msa.reservation.ReservationApi;
import com.watier.bot.reservation.model.ReservationModel;
import com.watier.bot.user.domain.KakaoUser;
import com.watier.bot.user.repository.KakaoUserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WaitingServiceImpl implements BotMenuService {

    private final @NonNull
    WatingDetailServiceImpl watingDetailService;

    private final @NonNull
    ContentComponent contentComponent;

    private final @NonNull
    ReservationApi reservationApi;

    private final @NonNull
    KakaoUserRepository kakaoUserRepository;

    @Override
    public BotResponseMessage contentProcess(BotRequestMessage requestMessage, String lastContext, List<String> contexts, KakaoUser kakaoUser) {
        BotResponseMessage res = new BotResponseMessage();
        BotButtons buttons = new BotButtons();

        KakaoUser user = this.kakaoUserRepository.findFirstByUserKey(requestMessage.getUser_key());

        List<ReservationModel> models = this.reservationApi.getWaitingList(user.getStoreId());
        models.forEach(model -> {
            buttons.addButton(model.getTitleText());
        });


        res.setMessage(new BotTextField(models.size() + " 개의 예약이 대기중입니다."));
        res.setKeyboard(models.isEmpty() ? this.contentComponent.getBasicMenu(requestMessage) : buttons);

        return res;
    }

    @Override
    public BotMenu myMenu() {
        return BotMenu.RESERVATION_WAITING;
    }

    @Override
    public BotMenuService getChildService() {
        return this.watingDetailService;
    }
}
