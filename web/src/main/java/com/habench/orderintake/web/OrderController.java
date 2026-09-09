package com.habench.orderintake.web;

import com.habench.orderintake.web.LedgerBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderintakeController")
public class OrderController {

    @GetMapping("/api/order/intake")
    public String refine(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Order-Correlation");
        LedgerBuilder.expand(orderNo);
        return "ok";
    }
}
