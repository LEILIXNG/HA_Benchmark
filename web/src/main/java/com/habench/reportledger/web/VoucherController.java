package com.habench.reportledger.web;

import com.habench.reportledger.web.ChannelRegistry;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportledgerController")
public class VoucherController {

    @GetMapping("/api/report/ledger")
    public String publish(
            @CookieValue("voucher_token") String userName) {
        ChannelRegistry.prepare(userName);
        return "ok";
    }
}
