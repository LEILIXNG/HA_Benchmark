package com.habench.vendordispatch.web;

import com.habench.vendordispatch.web.LedgerBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendordispatchController")
public class OrderController {

    @GetMapping("/api/vendor/dispatch")
    public String refine(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        LedgerBuilder.expand(orderNo);
        return "ok";
    }
}
