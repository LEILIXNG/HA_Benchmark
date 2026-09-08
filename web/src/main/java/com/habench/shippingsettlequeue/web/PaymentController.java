package com.habench.shippingsettlequeue.web;

import com.habench.shippingsettlequeue.web.CatalogCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsettlequeueController")
public class PaymentController {

    @GetMapping("/api/shipping/settlequeue/{label}")
    public String stage(
            @PathVariable("label") String label) {
        CatalogCollector.enrich(label);
        return "ok";
    }
}
