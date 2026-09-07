package com.habench.accountsettle.web;

import com.habench.accountsettle.web.QuoteResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountsettleController")
public class SessionController {

    @GetMapping("/api/account/settle")
    public String resolve(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        QuoteResolver.stage(category);
        return "ok";
    }
}
