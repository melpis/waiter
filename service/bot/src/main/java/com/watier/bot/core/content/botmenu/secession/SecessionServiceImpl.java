package com.watier.bot.core.content.botmenu.secession;

import com.watier.bot.core.content.service.BotMenuService;
import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import com.watier.bot.core.type.BotMenu;
import com.watier.bot.user.component.UserDataComponent;
import com.watier.bot.user.domain.KakaoUser;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecessionServiceImpl implements BotMenuService {

    private final @NonNull
    UserDataComponent userDataComponent;

    @Override
    public BotResponseMessage contentProcess(BotRequestMessage requestMessage, String lastContext, List<String> contexts, KakaoUser kakaoUser) {
        this.userDataComponent.deleteUser(kakaoUser);
        return null;
    }

    @Override
    public BotMenu myMenu() {
        return BotMenu.REMOVE_SERVICE;
    }

    @Override
    public BotMenuService getChildService() {
        return null;
    }
}
