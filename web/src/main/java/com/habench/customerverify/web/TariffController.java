package com.habench.customerverify.web;

import com.habench.customerverify.web.BatchPolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerverifyController")
public class TariffController {

    @GetMapping("/api/customer/verify/{userName}")
    public String compose(
            @PathVariable("userName") String userName) {
        BatchPolicy.prepare(userName);
        return "ok";
    }
}
