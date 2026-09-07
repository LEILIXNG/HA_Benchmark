package com.habench.accountexport.web;

import com.habench.accountexport.web.SessionBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountexportController")
public class PaymentController {

    @GetMapping("/api/account/export")
    public String attach(
            @RequestParam("tag") String tag) {
        SessionBroker.normalize(tag);
        return "ok";
    }
}
