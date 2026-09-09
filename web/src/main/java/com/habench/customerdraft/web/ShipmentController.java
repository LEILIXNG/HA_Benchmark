package com.habench.customerdraft.web;

import com.habench.customerdraft.web.RefundTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerdraftController")
public class ShipmentController {

    @GetMapping("/api/customer/draft")
    public String enrich(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Shipment-Context");
        RefundTranslator.collect(orderNo);
        return "ok";
    }
}
