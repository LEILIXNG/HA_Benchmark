package com.habench.inventorybind.web;

import com.habench.inventorybind.web.ManifestResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorybindController")
public class PaymentController {

    @GetMapping("/api/inventory/bind/{filename}")
    public String merge(
            @PathVariable("filename") String filename) {
        ManifestResolver.reconcile(filename);
        return "ok";
    }
}
