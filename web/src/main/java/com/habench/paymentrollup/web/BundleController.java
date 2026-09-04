package com.habench.paymentrollup.web;

import com.habench.paymentrollup.web.ContractBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentrollupController")
public class BundleController {

    @GetMapping("/api/payment/rollup")
    public String prepare(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        ContractBuilder.submit(resource);
        return "ok";
    }
}
