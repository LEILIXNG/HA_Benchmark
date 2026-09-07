package com.habench.cataloglookup.web;

import com.habench.cataloglookup.web.BatchAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("cataloglookupController")
public class ShipmentController {

    @GetMapping("/api/catalog/lookup/{target}")
    public String register(
            @PathVariable("target") String target) {
        BatchAdapter.expand(target);
        return "ok";
    }
}
