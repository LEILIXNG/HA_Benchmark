package com.habench.customerrelease.web;

import com.habench.customerrelease.web.VoucherAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerreleaseController")
public class TariffController {

    @GetMapping("/api/customer/release/{keyword}")
    public String stage(
            @PathVariable("keyword") String keyword) {
        VoucherAssembler.submit(keyword);
        return "ok";
    }
}
