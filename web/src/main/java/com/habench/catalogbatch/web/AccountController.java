package com.habench.catalogbatch.web;

import com.habench.catalogbatch.web.ChannelBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogbatchController")
public class AccountController {

    @GetMapping("/api/catalog/batch/{orderNo}")
    public String reconcile(
            @PathVariable("orderNo") String orderNo) {
        ChannelBroker.publish(orderNo);
        return "ok";
    }
}
