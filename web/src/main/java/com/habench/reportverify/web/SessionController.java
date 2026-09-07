package com.habench.reportverify.web;

import com.habench.reportverify.web.ContractService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportverifyController")
public class SessionController {

    @GetMapping("/api/report/verify")
    public String refine(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        ContractService.prepare(tag);
        return "ok";
    }
}
