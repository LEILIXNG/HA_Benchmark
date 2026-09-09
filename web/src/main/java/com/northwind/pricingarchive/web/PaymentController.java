package com.northwind.pricingarchive.web;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("pricingarchiveController")
@RequestMapping("/api/pricing")
public class PaymentController {
    private final QuoteRouter quoteRouter;

    public PaymentController(QuoteRouter quoteRouter) {
        this.quoteRouter = quoteRouter;
    }

    @GetMapping("/archive")
    public String collect(
            @CookieValue("payment_ref") String target) {
        this.quoteRouter.publish(target);
        return "accepted";
    }
}
