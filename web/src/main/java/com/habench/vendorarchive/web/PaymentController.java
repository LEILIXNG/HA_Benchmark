package com.habench.vendorarchive.web;

import com.habench.vendorarchive.web.VoucherResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorarchiveController")
public class PaymentController {

    @GetMapping("/api/vendor/archive")
    public String dispatch(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        VoucherResolver.refine(label);
        return "ok";
    }
}
