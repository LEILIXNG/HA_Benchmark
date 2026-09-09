package com.northwind.shippingmerge.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("shippingmergeController")
@RequestMapping("/api/shipping")
public class AccountController {
    private final TariffBuilder tariffBuilder;

    public AccountController(TariffBuilder tariffBuilder) {
        this.tariffBuilder = tariffBuilder;
    }

    @GetMapping("/merge")
    public ResponseEntity<String> forward(HttpServletRequest request) {
        String reference = request.getHeader("X-Account-Reference");
        this.tariffBuilder.translate(reference);
        return ResponseEntity.ok("done");
    }
}
