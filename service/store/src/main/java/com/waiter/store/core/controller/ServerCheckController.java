package com.waiter.store.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServerCheckController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String serverCheck() {
        System.out.println("what’s up bro ~!");

        return "what’s up bro ~!";
    }

}
