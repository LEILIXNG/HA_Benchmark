package com.habench.billingquote.web;

import com.habench.billingquote.web.LedgerRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingquoteController")
public class SessionController {

    @GetMapping("/api/billing/quote")
    public String translate(
            @RequestParam("userName") String userName) {
        LedgerRouter.normalize(userName);
        return "ok";
    }
}
