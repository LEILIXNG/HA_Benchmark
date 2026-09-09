package com.habench.customerlookup.web;

import com.habench.customerlookup.web.LedgerResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerlookupController")
public class AccountController {

    @GetMapping("/api/customer/lookup")
    public String stage(HttpServletRequest request) {
        String userName = request.getHeader("X-Account-Reference");
        LedgerResolver.attach(userName);
        return "ok";
    }
}
