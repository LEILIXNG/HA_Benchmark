package com.habench.orderbatch.web;

import com.habench.orderbatch.web.RefundRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderbatchController")
public class OrderController {

    @GetMapping("/api/order/batch")
    public String dispatch(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        RefundRegistry.forward(category);
        return "ok";
    }
}
