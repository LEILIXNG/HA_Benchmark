package com.habench.orderrollup.web;

import com.habench.orderrollup.web.VoucherCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderrollupController")
public class BundleController {

    @GetMapping("/api/order/rollup/{keyword}")
    public String publish(
            @PathVariable("keyword") String keyword) {
        VoucherCollector.merge(keyword);
        return "ok";
    }
}
