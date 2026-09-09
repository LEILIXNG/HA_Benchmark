package com.northwind.catalogposting.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("catalogpostingController")
@RequestMapping("/api/catalog")
public class AccountController {
    private final PaymentBuilder paymentBuilder;

    public AccountController(PaymentBuilder paymentBuilder) {
        this.paymentBuilder = paymentBuilder;
    }

    @GetMapping("/posting")
    public ResponseEntity<String> forward(
            @CookieValue("account_token") String keyword) {
        this.paymentBuilder.dispatch(keyword);
        return ResponseEntity.ok("accepted");
    }
}
