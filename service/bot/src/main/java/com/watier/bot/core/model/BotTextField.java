package com.watier.bot.core.model;

import lombok.Data;

@Data
public class BotTextField {
    private String text;

    public BotTextField(String s) {
        this.text = s;
    }
}
