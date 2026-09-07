package com.habench.accountrefund.web;

import com.habench.accountrefund.web.ManifestCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountrefundController")
public class VoucherController {

    @GetMapping("/api/account/refund")
    public String enrich(
            @RequestParam("userName") String userName) {
        ManifestCoordinator.assemble(userName);
        return "ok";
    }
}
