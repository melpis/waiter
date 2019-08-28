package com.watier.bot.core.controller;

import com.watier.bot.core.content.bean.ContentContext;
import com.watier.bot.core.content.botmenu.intro.StartService;
import com.watier.bot.core.content.component.ContentComponent;
import com.watier.bot.core.model.BotButtons;
import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import hsim.checkpoint.core.annotation.ValidationBody;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BotController {

    private final @NonNull
    ContentComponent contentComponent;

    private final @NonNull
    ContentContext contentContext;

    private final @NonNull
    StartService startService;

    @GetMapping("keyboard")
    public BotButtons getBasicMenu() {
        return this.startService.contentProcess();
    }

    @PostMapping("message")
    public BotResponseMessage processMessage(@ValidationBody BotRequestMessage botRequestMessage) {

        BotResponseMessage message = this.contentContext.processsContentService(botRequestMessage);

        if (message == null) {
            return this.contentComponent.getBasicMessage(botRequestMessage);
        }
        return message;
    }
}
