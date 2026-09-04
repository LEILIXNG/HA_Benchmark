package com.habench.billinglookup.web;

import com.habench.billinglookup.web.OrderAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billinglookupController")
public class AccountController {

    @GetMapping("/api/billing/lookup")
    public String translate(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        OrderAssembler.stage(label);
        return "ok";
    }
}
