package com.habench.reportsync.web;

import com.habench.reportsync.web.InvoiceBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsyncController")
public class RefundController {

    @GetMapping("/api/report/sync")
    public String refine(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        InvoiceBroker.publish(target);
        return "ok";
    }
}
