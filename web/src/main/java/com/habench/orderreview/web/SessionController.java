package com.habench.orderreview.web;

import com.habench.orderreview.web.LedgerBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreviewController")
public class SessionController {

    @GetMapping("/api/order/review")
    public String resolve(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        LedgerBuilder.assemble(reference);
        return "ok";
    }
}
