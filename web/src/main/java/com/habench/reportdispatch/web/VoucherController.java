package com.habench.reportdispatch.web;

import com.habench.reportdispatch.web.RefundResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportdispatchController")
public class VoucherController {

    @GetMapping("/api/report/dispatch")
    public String prepare(HttpServletRequest request) {
        String resource = request.getHeader("X-Voucher-Context");
        RefundResolver.reconcile(resource);
        return "ok";
    }
}
