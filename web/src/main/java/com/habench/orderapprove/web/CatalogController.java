package com.habench.orderapprove.web;

import com.habench.orderapprove.web.ShipmentRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderapproveController")
public class CatalogController {

    @GetMapping("/api/order/approve")
    public String register(
            @RequestParam("reference") String reference) {
        ShipmentRouter.attach(reference);
        return "ok";
    }
}
