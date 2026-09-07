package com.habench.vendorarchive.web;

import com.habench.vendorarchive.web.CatalogBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorarchiveController")
public class PaymentController {

    @GetMapping("/api/vendor/archive")
    public String route(
            @RequestParam("filename") String filename) {
        CatalogBuilder.prepare(filename);
        return "ok";
    }
}
