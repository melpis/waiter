package com.watier.bot.core.content.component;

import com.watier.bot.core.model.BotButtons;
import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import com.watier.bot.core.model.BotTextField;
import com.watier.bot.core.type.BotMenu;
import com.watier.bot.user.domain.KakaoUser;
import com.watier.bot.user.repository.KakaoUserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContentComponent {

    private final @NonNull
    KakaoUserRepository kakaoUserRepository;

    public BotButtons getIntroButton(BotRequestMessage botRequestMessage) {
        BotButtons botButtons = new BotButtons();
        botButtons.addButton(BotMenu.START_SERVICE);
        return botButtons;
    }

    public BotButtons getBasicMenu(BotRequestMessage botRequestMessage) {
        KakaoUser user = null;

        if (botRequestMessage != null) {
            user = kakaoUserRepository.findFirstByUserKey(botRequestMessage.getUser_key());
        }

        BotButtons botButtons = new BotButtons();

        if (user == null) {
            botButtons.addButton(BotMenu.JOIN_SERVICE);
        } else {
            botButtons.addButton(BotMenu.RESERVATION_WAITING, BotMenu.RESERVATION_LIST);
        }

        return botButtons;
    }

    public BotTextField getBasicTextField(String message) {
        if (message == null || message.isEmpty()) {
            message = "차세대 예약 서비스 Waiter입니다. 무엇을 도와 드릴까요?";
        }

        return new BotTextField(message);
    }


    public BotResponseMessage getBasicMessage(BotRequestMessage botRequestMessage) {
        return getBasicMessage(botRequestMessage, null);
    }

    public BotResponseMessage getBasicMessage(BotRequestMessage botRequestMessage, String message) {
        BotResponseMessage responseMessage = new BotResponseMessage();
        responseMessage.setKeyboard(this.getBasicMenu(botRequestMessage));
        responseMessage.setMessage(this.getBasicTextField(message));
        return responseMessage;
    }
}
