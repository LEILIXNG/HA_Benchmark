package com.habench.accountrefund.web;

import com.habench.accountrefund.web.BatchResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountrefundController")
public class VoucherController {

    @GetMapping("/api/account/refund")
    public String collect(
            @RequestParam("userName") String userName) {
        BatchResolver.compose(userName);
        return "ok";
    }
}
