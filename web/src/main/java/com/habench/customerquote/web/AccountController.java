package com.habench.customerquote.web;

import com.habench.customerquote.web.ShipmentResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerquoteController")
public class AccountController {

    @GetMapping("/api/customer/quote")
    public String merge(HttpServletRequest request) {
        String resource = request.getHeader("X-Account-Context");
        ShipmentResolver.stage(resource);
        return "ok";
    }
}
