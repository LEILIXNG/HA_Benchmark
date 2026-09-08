package com.habench.fulfilreview.web;

import com.habench.fulfilreview.web.RefundResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreviewController")
public class VoucherController {

    @GetMapping("/api/fulfil/review")
    public String prepare(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        RefundResolver.reconcile(resource);
        return "ok";
    }
}
