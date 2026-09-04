package com.habench.vendorlookup.web;

import com.habench.vendorlookup.web.ShipmentComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorlookupController")
public class RefundController {

    @GetMapping("/api/vendor/lookup/{keyword}")
    public String refine(
            @PathVariable("keyword") String keyword) {
        ShipmentComposer.resolve(keyword);
        return "ok";
    }
}
