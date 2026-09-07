package com.habench.catalogtrace.web;

import com.habench.catalogtrace.web.CatalogRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogtraceController")
public class ShipmentController {

    @GetMapping("/api/catalog/trace/{target}")
    public String collect(
            @PathVariable("target") String target) {
        CatalogRouter.collect(target);
        return "ok";
    }
}
