package com.habench.shippingexport.web;

import com.habench.shippingexport.web.LedgerResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingexportController")
public class VoucherController {

    @GetMapping("/api/shipping/export")
    public String resolve(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        LedgerResolver.translate(reference);
        return "ok";
    }
}
