package com.habench.ordergrant.web;

import com.habench.ordergrant.web.ReceiptNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordergrantController")
public class CatalogController {

    @GetMapping("/api/order/grant/{label}")
    public String publish(
            @PathVariable("label") String label) {
        ReceiptNormalizer.compose(label);
        return "ok";
    }
}
