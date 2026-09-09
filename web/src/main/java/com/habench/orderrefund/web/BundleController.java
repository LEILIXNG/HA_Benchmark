package com.habench.orderrefund.web;

import com.habench.orderrefund.web.AccountBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderrefundController")
public class BundleController {

    @GetMapping("/api/order/refund")
    public String refine(
            @RequestParam("filename") String filename) {
        AccountBuilder.route(filename);
        return "ok";
    }
}
