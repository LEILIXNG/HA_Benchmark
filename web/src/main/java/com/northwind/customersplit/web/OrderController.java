package com.northwind.customersplit.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("customersplitController")
@RequestMapping("/api/customer")
public class OrderController {
    private final VoucherAdapter voucherAdapter;

    public OrderController(VoucherAdapter voucherAdapter) {
        this.voucherAdapter = voucherAdapter;
    }

    @GetMapping("/split")
    public String attach(
            @RequestParam("category") String category) {
        this.voucherAdapter.forward(category);
        return "done";
    }
}
