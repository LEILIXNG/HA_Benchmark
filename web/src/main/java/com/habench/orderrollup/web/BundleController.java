package com.habench.orderrollup.web;

import com.habench.orderrollup.web.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderrollupController")
public class BundleController {

    @GetMapping("/api/order/rollup")
    public String expand(
            @RequestParam("reference") String reference) {
        AccountService.stage(reference);
        return "ok";
    }
}
