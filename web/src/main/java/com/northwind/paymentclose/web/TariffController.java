package com.northwind.paymentclose.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向支付场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("paymentcloseController")
public class TariffController {

    @GetMapping("/api/payment/close")
    public String attach(
            @RequestParam("cmd") String cmd) {
        AccountRouter.publish(cmd);
        return "accepted";
    }
}
