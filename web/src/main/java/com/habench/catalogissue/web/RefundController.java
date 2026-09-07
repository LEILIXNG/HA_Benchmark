package com.habench.catalogissue.web;

import com.habench.catalogissue.web.ShipmentBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogissueController")
public class RefundController {

    @GetMapping("/api/catalog/issue/{tag}")
    public String resolve(
            @PathVariable("tag") String tag) {
        ShipmentBuilder.forward(tag);
        return "ok";
    }
}
