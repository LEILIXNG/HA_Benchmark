package com.habench.paymentapprove.web;

import com.habench.paymentapprove.web.CatalogAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentapproveController")
public class AccountController {

    @GetMapping("/api/payment/approve")
    public String prepare(
            @RequestParam("label") String label) {
        CatalogAdapter.normalize(label);
        return "ok";
    }
}
