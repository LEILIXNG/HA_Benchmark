package com.habench.customerreconcile.web;

import com.habench.customerreconcile.web.ShipmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerreconcileController")
public class ShipmentController {

    @GetMapping("/api/customer/reconcile/{target}")
    public String route(
            @PathVariable("target") String target) {
        ShipmentService.publish(target);
        return "ok";
    }
}
