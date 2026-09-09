package com.habench.shippinghold.web;

import com.habench.shippinghold.web.ShipmentEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingholdController")
public class LedgerController {

    @GetMapping("/api/shipping/hold")
    public String forward(HttpServletRequest request) {
        String query = request.getHeader("X-Ledger-Channel");
        ShipmentEnricher.reconcile(query);
        return "ok";
    }
}
