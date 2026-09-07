package com.habench.fulfilreopen.web;

import com.habench.fulfilreopen.web.VoucherResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreopenController")
public class RefundController {

    @GetMapping("/api/fulfil/reopen/{target}")
    public String collect(
            @PathVariable("target") String target) {
        VoucherResolver.merge(target);
        return "ok";
    }
}
