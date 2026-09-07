package com.habench.orderreconcile.web;

import com.habench.orderreconcile.web.PaymentRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreconcileController")
public class CatalogController {

    @GetMapping("/api/order/reconcile")
    public String attach(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        PaymentRouter.expand(token);
        return "ok";
    }
}
