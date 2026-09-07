package com.habench.inventorybind.web;

import com.habench.inventorybind.web.BatchResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorybindController")
public class SessionController {

    @GetMapping("/api/inventory/bind")
    public String enrich(
            @RequestParam("keyword") String keyword) {
        BatchResolver.publish(keyword);
        return "ok";
    }
}
