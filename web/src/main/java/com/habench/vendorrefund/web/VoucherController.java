package com.habench.vendorrefund.web;

import com.habench.vendorrefund.web.ReceiptResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorrefundController")
public class VoucherController {

    @GetMapping("/api/vendor/refund")
    public String expand(
            @RequestParam("userName") String userName) {
        ReceiptResolver.merge(userName);
        return "ok";
    }
}
