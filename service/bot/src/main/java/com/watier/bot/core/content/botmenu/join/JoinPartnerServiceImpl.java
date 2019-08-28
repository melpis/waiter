package com.watier.bot.core.content.botmenu.join;

import com.watier.bot.core.content.botmenu.join.child.JoinStoreServiceImpl;
import com.watier.bot.core.content.service.BotMenuService;
import com.watier.bot.core.model.BotButtons;
import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import com.watier.bot.core.model.BotTextField;
import com.watier.bot.core.type.BotMenu;
import com.watier.bot.user.domain.KakaoUser;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoinPartnerServiceImpl implements BotMenuService {

    private final @NonNull
    JoinStoreServiceImpl joinPhoneService;

    @Override
    public BotResponseMessage contentProcess(BotRequestMessage requestMessage, String lastContext, List<String> contexts, KakaoUser kakaoUser) {
        if (kakaoUser.getStoreId() != null && kakaoUser.getStoreId() > 0 ) {
            return this.joinExistProcess(requestMessage, lastContext, contexts, kakaoUser);
        }
        BotResponseMessage responseMessage = new BotResponseMessage();
        BotTextField textField = new BotTextField("Waiter에 등록한 상점 아이디(숫자)를 입력해주세요");
        responseMessage.setMessage(textField);
        return responseMessage;
    }

    private BotResponseMessage joinExistProcess(BotRequestMessage requestMessage, String lastContext, List<String> contexts, KakaoUser kakaoUser) {
        BotResponseMessage responseMessage = new BotResponseMessage();

        responseMessage.setMessage(new BotTextField("이미 등록된 상점이 있습니다. 등록을 해제하고 다시 등록 하시겠습니까?"));

        BotButtons buttons = new BotButtons();
        buttons.addButton( BotMenu.REMOVE_SERVICE, BotMenu.RESERVATION_WAITING, BotMenu.RESERVATION_LIST);
        responseMessage.setKeyboard(buttons);

        return responseMessage;
    }

    @Override
    public BotMenu myMenu() {
        return BotMenu.JOIN_SERVICE;
    }

    @Override
    public BotMenuService getChildService() {
        return this.joinPhoneService;
    }
}
