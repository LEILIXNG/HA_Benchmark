package com.habench.shippingreconcile.web;

import com.habench.shippingreconcile.web.BundleBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingreconcileController")
public class PaymentController {

    @GetMapping("/api/shipping/reconcile")
    public String register(HttpServletRequest request) {
        String userName = request.getHeader("X-Payment-Client");
        BundleBroker.prepare(userName);
        return "ok";
    }
}
