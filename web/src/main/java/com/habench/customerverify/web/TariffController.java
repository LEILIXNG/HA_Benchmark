package com.habench.customerverify.web;

import com.habench.customerverify.web.VoucherRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerverifyController")
public class TariffController {

    @GetMapping("/api/customer/verify/{label}")
    public String enrich(
            @PathVariable("label") String label) {
        VoucherRouter.route(label);
        return "ok";
    }
}
