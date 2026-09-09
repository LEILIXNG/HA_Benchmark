package com.habench.billingclose.web;

import com.habench.billingclose.web.CatalogAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingcloseController")
public class ShipmentController {

    @GetMapping("/api/billing/close")
    public String dispatch(HttpServletRequest request) {
        String userName = request.getHeader("X-Shipment-Correlation");
        CatalogAdapter.assemble(userName);
        return "ok";
    }
}
