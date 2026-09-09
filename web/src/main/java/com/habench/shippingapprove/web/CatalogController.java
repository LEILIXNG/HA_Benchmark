package com.habench.shippingapprove.web;

import com.habench.shippingapprove.web.ManifestCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingapproveController")
public class CatalogController {

    @GetMapping("/api/shipping/approve")
    public String forward(
            @RequestHeader("X-Catalog-Tenant") String orderNo) {
        ManifestCollector.assemble(orderNo);
        return "ok";
    }
}
