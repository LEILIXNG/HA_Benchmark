package com.habench.billinglookup.web;

import com.habench.billinglookup.web.BatchBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billinglookupController")
public class ContractController {

    @GetMapping("/api/billing/lookup")
    public String register(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        BatchBuilder.refine(resource);
        return "ok";
    }
}
