package com.habench.reportsubmit.web;

import com.habench.reportsubmit.web.OrderCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportsubmitController")
public class InvoiceController {

    @GetMapping("/api/report/submit")
    public String resolve(HttpServletRequest request) {
        String category = request.getHeader("X-Invoice-Tenant");
        OrderCollector.refine(category);
        return "ok";
    }
}
