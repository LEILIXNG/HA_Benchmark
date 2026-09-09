package com.habench.reportrollup.web;

import com.habench.reportrollup.web.QuoteBroker;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportrollupController")
public class AccountController {

    @GetMapping("/api/report/rollup")
    public String collect(
            @CookieValue("account_ctx") String resource) {
        QuoteBroker.enrich(resource);
        return "ok";
    }
}
