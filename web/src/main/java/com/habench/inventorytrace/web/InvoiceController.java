package com.habench.inventorytrace.web;

import com.habench.inventorytrace.web.ShipmentCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorytraceController")
public class InvoiceController {

    @GetMapping("/api/inventory/trace")
    public String assemble(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        ShipmentCoordinator.normalize(orderNo);
        return "ok";
    }
}
