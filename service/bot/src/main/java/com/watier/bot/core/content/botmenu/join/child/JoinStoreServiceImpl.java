package com.watier.bot.core.content.botmenu.join.child;

import com.watier.bot.core.content.service.BotMenuService;
import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import com.watier.bot.core.type.BotMenu;
import com.watier.bot.user.component.UserDataComponent;
import com.watier.bot.user.domain.KakaoUser;
import com.watier.bot.user.repository.KakaoUserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoinStoreServiceImpl implements BotMenuService {

    private final @NonNull
    KakaoUserRepository kakaoUserRepository;

    private final UserDataComponent userDataComponent;

    @Override
    public BotResponseMessage contentProcess(BotRequestMessage requestMessage, String lastContext, List<String> contexts, KakaoUser kakaoUser) {

        Long storeId = Long.parseLong(requestMessage.getContent());
        this.userDataComponent.cleanlUserFromSoreId(storeId);

        kakaoUser.setStoreId(storeId);
        this.kakaoUserRepository.save(kakaoUser);

        return null;
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
