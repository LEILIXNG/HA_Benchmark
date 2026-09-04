package com.habench.shippinggrant.web;

import com.habench.shippinggrant.web.ShipmentBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippinggrantController")
public class CatalogController {

    @GetMapping("/api/shipping/grant/{tag}")
    public String merge(
            @PathVariable("tag") String tag) {
        ShipmentBuilder.compose(tag);
        return "ok";
    }
}
