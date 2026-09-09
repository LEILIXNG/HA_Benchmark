package com.habench.orderreconcile.web;

import com.habench.orderreconcile.web.OrderTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreconcileController")
public class RefundController {

    @GetMapping("/api/order/reconcile")
    public String reconcile(HttpServletRequest request) {
        String reference = request.getHeader("X-Refund-Origin");
        OrderTranslator.reconcile(reference);
        return "ok";
    }
}
