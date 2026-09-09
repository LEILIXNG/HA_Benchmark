package com.habench.pricingassign.web;

import com.habench.pricingassign.web.TariffAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingassignController")
public class ShipmentController {

    @GetMapping("/api/pricing/assign")
    public String expand(
            @RequestHeader("X-Shipment-Origin") String label) {
        TariffAssembler.stage(label);
        return "ok";
    }
}
