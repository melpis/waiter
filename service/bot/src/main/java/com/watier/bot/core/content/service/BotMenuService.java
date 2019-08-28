package com.watier.bot.core.content.service;

import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import com.watier.bot.core.type.BotMenu;
import com.watier.bot.user.domain.KakaoUser;

import java.util.List;

public interface BotMenuService {

    BotResponseMessage contentProcess(BotRequestMessage requestMessage, String lastContext, List<String> contexts, KakaoUser kakaoUser);

    BotMenu myMenu();

    BotMenuService getChildService();
}
