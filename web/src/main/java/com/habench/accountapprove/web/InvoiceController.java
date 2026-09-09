package com.habench.accountapprove.web;

import com.habench.accountapprove.web.SessionResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountapproveController")
public class InvoiceController {

    @GetMapping("/api/account/approve")
    public String prepare(
            @RequestHeader("X-Invoice-Client") String resource) {
        SessionResolver.stage(resource);
        return "ok";
    }
}
