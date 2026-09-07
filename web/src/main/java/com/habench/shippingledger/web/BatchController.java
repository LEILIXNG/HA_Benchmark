package com.habench.shippingledger.web;

import com.habench.shippingledger.web.CatalogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingledgerController")
public class BatchController {

    @GetMapping("/api/shipping/ledger")
    public String reconcile(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        CatalogService.publish(query);
        return "ok";
    }
}
