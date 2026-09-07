package com.habench.fulfilposting.web;

import com.habench.fulfilposting.web.ShipmentBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilpostingController")
public class ReceiptController {

    @GetMapping("/api/fulfil/posting/{tag}")
    public String submit(
            @PathVariable("tag") String tag) {
        ShipmentBuilder.stage(tag);
        return "ok";
    }
}
