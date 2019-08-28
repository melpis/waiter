package com.watier.bot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BotConfig {

    @Value("${gateway.url}")
    private String gateWayUrl;
}
