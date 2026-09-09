package com.northwind.pricingbatch.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向定价场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("pricingbatchController")
@RequestMapping("/api/pricing")
public class ReceiptController {
    private final TariffAdapter tariffAdapter;

    public ReceiptController(TariffAdapter tariffAdapter) {
        this.tariffAdapter = tariffAdapter;
    }

    @GetMapping("/batch")
    public String compose(
            @RequestHeader("X-Receipt-Correlation") String category) {
        this.tariffAdapter.attach(category);
        return "accepted";
    }
}
