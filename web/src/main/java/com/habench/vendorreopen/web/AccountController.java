package com.habench.vendorreopen.web;

import com.habench.vendorreopen.web.SessionService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreopenController")
public class AccountController {

    @GetMapping("/api/vendor/reopen")
    public String resolve(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        SessionService.compose(reference);
        return "ok";
    }
}
