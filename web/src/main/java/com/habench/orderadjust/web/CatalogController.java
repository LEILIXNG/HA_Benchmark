package com.habench.orderadjust.web;

import com.habench.orderadjust.web.ReceiptNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderadjustController")
public class CatalogController {

    @GetMapping("/api/order/adjust/{label}")
    public String publish(
            @PathVariable("label") String label) {
        ReceiptNormalizer.compose(label);
        return "ok";
    }
}
