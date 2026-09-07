package com.habench.vendorverify.web;

import com.habench.vendorverify.web.ShipmentRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorverifyController")
public class CatalogController {

    @GetMapping("/api/vendor/verify")
    public String register(
            @RequestParam("reference") String reference) {
        ShipmentRouter.attach(reference);
        return "ok";
    }
}
