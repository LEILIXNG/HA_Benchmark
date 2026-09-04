package com.habench.inventoryreview.web;

import com.habench.inventoryreview.web.PaymentAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryreviewController")
public class ManifestController {

    @GetMapping("/api/inventory/review")
    public String stage(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        PaymentAssembler.publish(token);
        return "ok";
    }
}
