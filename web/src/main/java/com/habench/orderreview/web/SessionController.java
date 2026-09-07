package com.habench.orderreview.web;

import com.habench.orderreview.web.ContractCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreviewController")
public class SessionController {

    @GetMapping("/api/order/review")
    public String register(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        ContractCoordinator.normalize(userName);
        return "ok";
    }
}
