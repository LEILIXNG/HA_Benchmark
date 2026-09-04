package com.habench.orderrollup.web;

import com.habench.orderrollup.web.ReceiptGuard;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderrollupController")
public class PaymentController {

    @GetMapping("/api/order/rollup")
    public String assemble(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        ReceiptGuard.refine(keyword);
        return "ok";
    }
}
