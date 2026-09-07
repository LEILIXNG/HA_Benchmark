package com.habench.reportbind.web;

import com.habench.reportbind.web.RefundResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportbindController")
public class ContractController {

    @GetMapping("/api/report/bind")
    public String assemble(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        RefundResolver.assemble(reference);
        return "ok";
    }
}
