package com.habench.catalogrollup.web;

import com.habench.catalogrollup.web.ShipmentCollector;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogrollupController")
public class ContractController {

    @GetMapping("/api/catalog/rollup")
    public String route(
            @CookieValue("contract_tag") String query) {
        ShipmentCollector.expand(query);
        return "ok";
    }
}
