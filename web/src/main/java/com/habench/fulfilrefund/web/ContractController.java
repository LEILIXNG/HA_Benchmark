package com.habench.fulfilrefund.web;

import com.habench.fulfilrefund.web.InvoiceFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilrefundController")
public class ContractController {

    @GetMapping("/api/fulfil/refund")
    public String forward(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        InvoiceFacade.enrich(reference);
        return "ok";
    }
}
