package com.habench.customerposting.web;

import com.habench.customerposting.web.ContractAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerpostingController")
public class QuoteController {

    @GetMapping("/api/customer/posting")
    public String expand(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        ContractAssembler.enrich(reference);
        return "ok";
    }
}
