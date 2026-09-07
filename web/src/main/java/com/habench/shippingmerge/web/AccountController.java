package com.habench.shippingmerge.web;

import com.habench.shippingmerge.web.RefundRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingmergeController")
public class AccountController {

    @GetMapping("/api/shipping/merge")
    public String reconcile(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        RefundRouter.enrich(token);
        return "ok";
    }
}
