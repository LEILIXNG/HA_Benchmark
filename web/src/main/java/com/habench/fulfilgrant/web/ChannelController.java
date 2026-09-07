package com.habench.fulfilgrant.web;

import com.habench.fulfilgrant.web.SessionBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilgrantController")
public class ChannelController {

    @GetMapping("/api/fulfil/grant")
    public String route(
            @RequestParam("userName") String userName) {
        SessionBroker.assemble(userName);
        return "ok";
    }
}
