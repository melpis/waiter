package com.watier.bot.core.model;

import lombok.Data;

@Data
public class BotRequestMessage {

    private String user_key;
    private String type;
    private String content;


    public Long getReservationId(String ct1){
        String ct = ct1;
        if (ct == null){
            ct = this.content;
        }
        return Long.parseLong(ct.substring(0, ct.indexOf(".")));
    }
}
