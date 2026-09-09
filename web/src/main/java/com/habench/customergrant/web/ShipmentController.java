package com.habench.customergrant.web;

import com.habench.customergrant.web.CatalogCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("customergrantController")
public class ShipmentController {

    @GetMapping("/api/customer/grant")
    public String expand(
            @RequestHeader("X-Shipment-Origin") String tag) {
        CatalogCoordinator.forward(tag);
        return "ok";
    }
}
