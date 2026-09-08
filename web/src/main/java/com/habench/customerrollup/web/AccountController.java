package com.habench.customerrollup.web;

import com.habench.customerrollup.web.BatchComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerrollupController")
public class AccountController {

    @GetMapping("/api/customer/rollup/{tag}")
    public String expand(
            @PathVariable("tag") String tag) {
        BatchComposer.prepare(tag);
        return "ok";
    }
}
