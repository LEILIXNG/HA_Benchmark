package com.habench.orderclose.web;

import com.habench.orderclose.web.OrderAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordercloseController")
public class ManifestController {

    @GetMapping("/api/order/close")
    public String submit(
            @RequestHeader("X-Manifest-Context") String filename) {
        OrderAdapter.route(filename);
        return "ok";
    }
}
