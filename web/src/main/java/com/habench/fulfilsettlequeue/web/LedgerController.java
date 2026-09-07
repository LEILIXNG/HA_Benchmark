package com.habench.fulfilsettlequeue.web;

import com.habench.fulfilsettlequeue.web.ChannelCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsettlequeueController")
public class LedgerController {

    @GetMapping("/api/fulfil/settlequeue")
    public String normalize(
            @RequestParam("userName") String userName) {
        ChannelCoordinator.collect(userName);
        return "ok";
    }
}
