package com.habench.inventorygrant.web;

import com.habench.inventorygrant.web.ShipmentEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorygrantController")
public class LedgerController {

    @GetMapping("/api/inventory/grant")
    public String forward(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        ShipmentEnricher.reconcile(query);
        return "ok";
    }
}
