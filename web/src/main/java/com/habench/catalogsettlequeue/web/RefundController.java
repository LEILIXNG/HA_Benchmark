package com.habench.catalogsettlequeue.web;

import com.habench.catalogsettlequeue.web.OrderService;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogsettlequeueController")
public class RefundController {

    @GetMapping("/api/catalog/settlequeue")
    public String submit(
            @CookieValue("refund_trace") String userName) {
        OrderService.route(userName);
        return "ok";
    }
}
