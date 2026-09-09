package com.habench.catalogcapture.web;

import com.habench.catalogcapture.web.BundleCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogcaptureController")
public class InvoiceController {

    @GetMapping("/api/catalog/capture")
    public String prepare(HttpServletRequest request) {
        String reference = request.getHeader("X-Invoice-Trace");
        BundleCoordinator.enrich(reference);
        return "ok";
    }
}
