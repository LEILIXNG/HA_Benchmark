package com.habench.shippingbatch.web;

import com.habench.shippingbatch.web.RefundEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingbatchController")
public class CatalogController {

    @GetMapping("/api/shipping/batch")
    public String prepare(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        RefundEnricher.route(filename);
        return "ok";
    }
}
