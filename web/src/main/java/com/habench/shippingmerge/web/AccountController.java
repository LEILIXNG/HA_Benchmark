package com.habench.shippingmerge.web;

import com.habench.shippingmerge.web.TariffBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingmergeController")
public class AccountController {

    @GetMapping("/api/shipping/merge")
    public String forward(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        TariffBuilder.translate(reference);
        return "ok";
    }
}
