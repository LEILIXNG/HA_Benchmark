package com.habench.fulfilposting.web;

import com.habench.fulfilposting.web.ShipmentBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilpostingController")
public class ReceiptController {

    @GetMapping("/api/fulfil/posting/{label}")
    public String submit(
            @PathVariable("label") String label) {
        ShipmentBuilder.stage(label);
        return "ok";
    }
}
