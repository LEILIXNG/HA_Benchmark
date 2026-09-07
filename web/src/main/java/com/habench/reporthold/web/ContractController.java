package com.habench.reporthold.web;

import com.habench.reporthold.web.AccountBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportholdController")
public class ContractController {

    @GetMapping("/api/report/hold")
    public String forward(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        AccountBroker.merge(target);
        return "ok";
    }
}
