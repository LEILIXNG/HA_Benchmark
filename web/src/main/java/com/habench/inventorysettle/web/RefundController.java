package com.habench.inventorysettle.web;

import com.habench.inventorysettle.web.TariffCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorysettleController")
public class RefundController {

    @GetMapping("/api/inventory/settle")
    public String translate(
            @RequestParam("resource") String resource) {
        TariffCoordinator.register(resource);
        return "ok";
    }
}
