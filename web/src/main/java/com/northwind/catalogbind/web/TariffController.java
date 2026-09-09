package com.northwind.catalogbind.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("catalogbindController")
public class TariffController {
    private final PaymentAssembler paymentAssembler;

    public TariffController(PaymentAssembler paymentAssembler) {
        this.paymentAssembler = paymentAssembler;
    }

    @GetMapping("/api/catalog/bind/{category}")
    public ResponseEntity<String> compose(
            @PathVariable("category") String category) {
        this.paymentAssembler.forward(category);
        return ResponseEntity.ok("done");
    }
}
