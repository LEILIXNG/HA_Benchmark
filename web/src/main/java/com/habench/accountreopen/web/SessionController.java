package com.habench.accountreopen.web;

import com.habench.accountreopen.web.ShipmentRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountreopenController")
public class SessionController {

    @GetMapping("/api/account/reopen/{query}")
    public String reconcile(
            @PathVariable("query") String query) {
        ShipmentRegistry.merge(query);
        return "ok";
    }
}
