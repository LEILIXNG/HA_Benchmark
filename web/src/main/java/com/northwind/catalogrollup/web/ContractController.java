package com.northwind.catalogrollup.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("catalogrollupController")
public class ContractController {
    private final QuoteCollector quoteCollector;

    public ContractController(QuoteCollector quoteCollector) {
        this.quoteCollector = quoteCollector;
    }

    @GetMapping("/api/catalog/rollup")
    public ResponseEntity<String> forward(
            @CookieValue("contract_tag") String query) {
        this.quoteCollector.publish(query);
        return ResponseEntity.ok("accepted");
    }
}
