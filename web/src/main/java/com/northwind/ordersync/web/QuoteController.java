package com.northwind.ordersync.web;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("ordersyncController")
public class QuoteController {
    private final ReceiptFacade receiptFacade;

    public QuoteController(ReceiptFacade receiptFacade) {
        this.receiptFacade = receiptFacade;
    }

    @GetMapping("/api/order/sync")
    public String compose(
            @CookieValue("quote_token") String keyword) {
        this.receiptFacade.compose(keyword);
        return "accepted";
    }
}
