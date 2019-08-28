package com.watier.bot.core.content.botmenu.intro;

import com.watier.bot.core.content.component.ContentComponent;
import com.watier.bot.core.model.BotButtons;
import com.watier.bot.core.type.BotMenu;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StartService {

    public BotButtons contentProcess() {
        BotButtons botButtons = new BotButtons();
        botButtons.addButton(BotMenu.JOIN_SERVICE, BotMenu.RESERVATION_WAITING, BotMenu.RESERVATION_LIST);
        return botButtons;
    }
}
