package com.habench.catalogrelease.web;

import com.habench.catalogrelease.web.ShipmentBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogreleaseController")
public class InvoiceController {

    @GetMapping("/api/catalog/release")
    public String prepare(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Invoice-Client");
        ShipmentBroker.enrich(orderNo);
        return "ok";
    }
}
