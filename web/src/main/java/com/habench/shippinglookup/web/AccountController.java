package com.habench.shippinglookup.web;

import com.habench.shippinglookup.web.LedgerResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippinglookupController")
public class AccountController {

    @GetMapping("/api/shipping/lookup")
    public String stage(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        LedgerResolver.attach(userName);
        return "ok";
    }
}
