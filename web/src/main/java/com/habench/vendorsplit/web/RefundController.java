package com.habench.vendorsplit.web;

import com.habench.vendorsplit.web.ShipmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsplitController")
public class RefundController {

    @GetMapping("/api/vendor/split")
    public String reconcile(
            @RequestParam("token") String token) {
        ShipmentService.register(token);
        return "ok";
    }
}
