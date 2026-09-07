package com.habench.ordersubmit.web;

import com.habench.ordersubmit.web.BundleCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersubmitController")
public class InvoiceController {

    @GetMapping("/api/order/submit")
    public String collect(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        BundleCollector.reconcile(category);
        return "ok";
    }
}
