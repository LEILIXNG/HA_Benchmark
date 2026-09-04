package com.habench.fulfilgrant.web;

import com.habench.fulfilgrant.web.VoucherFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilgrantController")
public class ChannelController {

    @GetMapping("/api/fulfil/grant")
    public String attach(
            @RequestParam("target") String target) {
        VoucherFacade.attach(target);
        return "ok";
    }
}
