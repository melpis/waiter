package com.watier.bot.core.model;

import com.watier.bot.core.type.BotMenu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BotButtons {

    private String type = "buttons";
    private List<String> buttons;

    public void addButton(BotMenu... menus) {
        if (this.buttons == null) {
            this.buttons = new ArrayList<>();
        }

        for (BotMenu menu : menus) {
            this.buttons.add(menu.getButtonStr());
        }
    }

    public void addButton(String... buttons) {
        if (this.buttons == null) {
            this.buttons = new ArrayList<>();
        }

        for (String button : buttons) {
            this.buttons.add(button);
        }
    }
}
