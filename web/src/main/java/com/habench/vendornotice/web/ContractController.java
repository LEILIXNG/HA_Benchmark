package com.habench.vendornotice.web;

import com.habench.vendornotice.web.VoucherBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendornoticeController")
public class ContractController {

    @GetMapping("/api/vendor/notice")
    public String reconcile(
            @RequestParam("orderNo") String orderNo) {
        VoucherBuilder.translate(orderNo);
        return "ok";
    }
}
