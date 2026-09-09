package com.habench.paymentreconcile.web;

import com.habench.paymentreconcile.web.ShipmentCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreconcileController")
public class ManifestController {

    @GetMapping("/api/payment/reconcile/{filename}")
    public String submit(
            @PathVariable("filename") String filename) {
        ShipmentCollector.register(filename);
        return "ok";
    }
}
