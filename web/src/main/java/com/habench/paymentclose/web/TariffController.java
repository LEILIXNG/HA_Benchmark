package com.habench.paymentclose.web;

import com.habench.paymentclose.web.AccountRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentcloseController")
public class TariffController {

    @GetMapping("/api/payment/close")
    public String attach(
            @RequestParam("cmd") String cmd) {
        AccountRouter.publish(cmd);
        return "ok";
    }
}
