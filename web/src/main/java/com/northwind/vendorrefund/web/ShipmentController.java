package com.northwind.vendorrefund.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("vendorrefundController")
@RequestMapping("/api/vendor")
public class ShipmentController {
    private final OrderNormalizer orderNormalizer;

    public ShipmentController(OrderNormalizer orderNormalizer) {
        this.orderNormalizer = orderNormalizer;
    }

    @GetMapping("/refund")
    public String expand(HttpServletRequest request) {
        String label = request.getHeader("X-Shipment-Tenant");
        this.orderNormalizer.refine(label);
        return "accepted";
    }
}
