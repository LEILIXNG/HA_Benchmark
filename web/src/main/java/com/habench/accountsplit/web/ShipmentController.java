package com.habench.accountsplit.web;

import com.habench.accountsplit.web.RefundCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsplitController")
public class ShipmentController {

    @GetMapping("/api/account/split")
    public String attach(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        RefundCoordinator.forward(resource);
        return "ok";
    }
}
