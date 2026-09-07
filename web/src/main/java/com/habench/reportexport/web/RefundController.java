package com.habench.reportexport.web;

import com.habench.reportexport.web.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportexportController")
public class RefundController {

    @GetMapping("/api/report/export/{token}")
    public String prepare(
            @PathVariable("token") String token) {
        SessionService.expand(token);
        return "ok";
    }
}
