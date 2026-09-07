package com.habench.billingsettlequeue.web;

import com.habench.billingsettlequeue.web.RefundRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingsettlequeueController")
public class TariffController {

    @GetMapping("/api/billing/settlequeue")
    public String merge(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        RefundRegistry.collect(category);
        return "ok";
    }
}
