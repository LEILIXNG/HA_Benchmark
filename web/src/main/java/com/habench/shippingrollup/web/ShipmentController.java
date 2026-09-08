package com.habench.shippingrollup.web;

import com.habench.shippingrollup.web.BatchFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingrollupController")
public class ShipmentController {

    @GetMapping("/api/shipping/rollup/{target}")
    public String expand(
            @PathVariable("target") String target) {
        BatchFacade.reconcile(target);
        return "ok";
    }
}
