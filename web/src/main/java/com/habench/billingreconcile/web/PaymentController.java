package com.habench.billingreconcile.web;

import com.habench.billingreconcile.web.ReceiptCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreconcileController")
public class PaymentController {

    @GetMapping("/api/billing/reconcile")
    public String stage(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ReceiptCoordinator.attach(target);
        return "ok";
    }
}
