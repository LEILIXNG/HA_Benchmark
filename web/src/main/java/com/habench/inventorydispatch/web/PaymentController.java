package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.BundleBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydispatchController")
public class PaymentController {

    @GetMapping("/api/inventory/dispatch")
    public String register(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        BundleBroker.prepare(userName);
        return "ok";
    }
}
