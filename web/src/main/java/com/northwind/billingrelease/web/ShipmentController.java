package com.northwind.billingrelease.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账务场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("billingreleaseController")
public class ShipmentController {

    @GetMapping("/api/billing/release")
    public String resolve(HttpServletRequest request) {
        String filename = request.getHeader("X-Shipment-Tenant");
        BatchComposer.enrich(filename);
        return "ok";
    }
}
