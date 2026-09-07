package com.habench.ordermanifest.web;

import com.habench.ordermanifest.web.AccountAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordermanifestController")
public class ShipmentController {

    @GetMapping("/api/order/manifest")
    public String reconcile(
            @RequestParam("target") String target) {
        AccountAdapter.route(target);
        return "ok";
    }
}
