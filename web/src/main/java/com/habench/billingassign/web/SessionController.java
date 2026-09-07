package com.habench.billingassign.web;

import com.habench.billingassign.web.LedgerService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingassignController")
public class SessionController {

    @GetMapping("/api/billing/assign")
    public String expand(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        LedgerService.refine(tag);
        return "ok";
    }
}
