package com.watier.bot.core.type;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum BotMenu {
    START_SERVICE("시작하기", null),
    JOIN_SERVICE("상점 등록", null),
    REMOVE_SERVICE("상점 등록 해제", null),
    RESERVATION_WAITING("예약대기 현황", null),
    RESERVATION_LIST("예약 현황", null),
    RESERVATION_ACCEPT("예약 수락", RESERVATION_WAITING),
    RESERVATION_REJECT("예약 거절", RESERVATION_WAITING);

    private final String buttonStr;
    private final BotMenu parent;

    BotMenu(String buttonStr, BotMenu parent) {
        this.buttonStr = buttonStr;
        this.parent = parent;
    }

    public static BotMenu findByValue(String str) {
        return Arrays.stream(BotMenu.values()).filter(bm -> bm.getButtonStr().equals(str)).findFirst().orElse(null);
    }
}
