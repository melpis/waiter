package com.watier.bot.core.model;

import lombok.Data;

@Data
public class BotResponseMessage {

    private BotTextField message;
    private BotButtons keyboard;
}
