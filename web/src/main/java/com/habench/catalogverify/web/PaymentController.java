package com.habench.catalogverify.web;

import com.habench.catalogverify.web.ChannelRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogverifyController")
public class PaymentController {

    @GetMapping("/api/catalog/verify")
    public String enrich(
            @RequestHeader("X-Payment-Correlation") String userName) {
        ChannelRouter.publish(userName);
        return "ok";
    }
}
