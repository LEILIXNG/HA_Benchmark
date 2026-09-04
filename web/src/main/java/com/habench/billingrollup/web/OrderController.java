package com.habench.billingrollup.web;

import com.habench.billingrollup.web.ContractService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingrollupController")
public class OrderController {

    @GetMapping("/api/billing/rollup")
    public String stage(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ContractService.dispatch(category);
        return "ok";
    }
}
