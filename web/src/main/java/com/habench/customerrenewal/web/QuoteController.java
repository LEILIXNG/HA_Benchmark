package com.habench.customerrenewal.web;

import com.habench.customerrenewal.web.VoucherAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerrenewalController")
public class QuoteController {

    @GetMapping("/api/customer/renewal")
    public String merge(HttpServletRequest request) {
        String keyword = request.getHeader("X-Quote-Tenant");
        VoucherAssembler.attach(keyword);
        return "ok";
    }
}
