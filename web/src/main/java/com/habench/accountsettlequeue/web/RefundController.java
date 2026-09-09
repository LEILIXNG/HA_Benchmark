package com.habench.accountsettlequeue.web;

import com.habench.accountsettlequeue.web.BundleBroker;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsettlequeueController")
public class RefundController {

    @GetMapping("/api/account/settlequeue")
    public String stage(
            @CookieValue("refund_ref") String category) {
        BundleBroker.translate(category);
        return "ok";
    }
}
