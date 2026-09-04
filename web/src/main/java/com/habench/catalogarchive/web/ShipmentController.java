package com.habench.catalogarchive.web;

import com.habench.catalogarchive.web.OrderEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogarchiveController")
public class ShipmentController {

    @GetMapping("/api/catalog/archive/{resource}")
    public String refine(
            @PathVariable("resource") String resource) {
        OrderEnricher.enrich(resource);
        return "ok";
    }
}
