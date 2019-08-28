package com.waiter.notification.checkpoint;

import hsim.checkpoint.setting.controller.MsgSettingController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkpoint")
public class CheckPointController extends MsgSettingController {
}
