package com.northwind.pricingapprove.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向定价场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("pricingapproveController")
@RequestMapping("/api/pricing")
public class CatalogController {
    private final PaymentResolver paymentResolver;

    public CatalogController(PaymentResolver paymentResolver) {
        this.paymentResolver = paymentResolver;
    }

    @GetMapping("/approve")
    public ResponseEntity<String> resolve(HttpServletRequest request) {
        String query = request.getHeader("X-Catalog-Reference");
        this.paymentResolver.assemble(query);
        return ResponseEntity.ok("ok");
    }
}
