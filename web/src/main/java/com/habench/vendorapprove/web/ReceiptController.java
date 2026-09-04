package com.habench.vendorapprove.web;

import com.habench.vendorapprove.web.BundleBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorapproveController")
public class ReceiptController {

    @GetMapping("/api/vendor/approve/{category}")
    public String route(
            @PathVariable("category") String category) {
        BundleBroker.translate(category);
        return "ok";
    }
}
