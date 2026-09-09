package com.habench.vendorbatch.web;

import com.habench.vendorbatch.web.SessionRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorbatchController")
public class LedgerController {

    @GetMapping("/api/vendor/batch")
    public String assemble(HttpServletRequest request) {
        String userName = request.getHeader("X-Ledger-Context");
        SessionRegistry.refine(userName);
        return "ok";
    }
}
