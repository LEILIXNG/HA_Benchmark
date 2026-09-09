package com.habench.billingrelease.web;

import com.habench.billingrelease.web.BatchComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreleaseController")
public class ShipmentController {

    @GetMapping("/api/billing/release")
    public String resolve(HttpServletRequest request) {
        String filename = request.getHeader("X-Shipment-Tenant");
        BatchComposer.enrich(filename);
        return "ok";
    }
}
