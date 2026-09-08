package com.habench.orderclose.web;

import com.habench.orderclose.web.ReceiptNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordercloseController")
public class CatalogController {

    @GetMapping("/api/order/close/{label}")
    public String publish(
            @PathVariable("label") String label) {
        ReceiptNormalizer.compose(label);
        return "ok";
    }
}
