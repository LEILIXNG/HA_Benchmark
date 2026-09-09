package com.habench.accountsubmit.web;

import com.habench.accountsubmit.web.ManifestEnricher;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsubmitController")
public class SessionController {

    @GetMapping("/api/account/submit")
    public String dispatch(
            @CookieValue("session_trace") String resource) {
        ManifestEnricher.translate(resource);
        return "ok";
    }
}
