package com.watier.bot.core.content.botmenu.waiting.child.type;

import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
public enum ReservationAccept {

    ACCEPT("수락"),
    REJECT("거절");

    private final String str;

    ReservationAccept(String str) {
        this.str = str;
    }

    public static ReservationAccept findByStr(String str) {
        return Arrays.stream(ReservationAccept.values()).filter(ra -> ra.getStr().equals(str)).findFirst().orElse(null);
    }

    public static String[] getAllStrs() {
        String[] strs = new String[values().length];
        return Arrays.stream(values()).map(value -> value.getStr()).collect(Collectors.toList()).toArray(strs);
    }
}