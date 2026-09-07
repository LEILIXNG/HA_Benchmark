package com.habench.pricingreview.web;

import com.habench.pricingreview.web.RefundResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreviewController")
public class VoucherController {

    @GetMapping("/api/pricing/review")
    public String prepare(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        RefundResolver.reconcile(resource);
        return "ok";
    }
}
