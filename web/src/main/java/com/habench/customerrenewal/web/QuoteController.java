package com.habench.customerrenewal.web;

import com.habench.customerrenewal.web.LedgerAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerrenewalController")
public class QuoteController {

    @GetMapping("/api/customer/renewal")
    public String dispatch(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        LedgerAdapter.stage(category);
        return "ok";
    }
}
