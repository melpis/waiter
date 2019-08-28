package com.waiter.sms.push.token.controller;

import com.waiter.sms.push.token.entity.SmsMsg;
import com.waiter.sms.push.token.service.SmsSendService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SmsController {
    private final @NonNull
    SmsSendService smsSendService;

    @PostMapping("/send")
    public void sendSms(@RequestBody SmsMsg smsMsg) {
        this.smsSendService.sendSms(smsMsg);
    }


    @GetMapping("/callback/{id}")
    public void sendSms(@PathVariable Long id) {
        this.smsSendService.callback(id);
    }


}
