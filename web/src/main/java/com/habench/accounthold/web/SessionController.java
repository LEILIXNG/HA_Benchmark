package com.habench.accounthold.web;

import com.habench.accounthold.web.TariffTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountholdController")
public class SessionController {

    @GetMapping("/api/account/hold")
    public String enrich(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        TariffTranslator.publish(reference);
        return "ok";
    }
}
