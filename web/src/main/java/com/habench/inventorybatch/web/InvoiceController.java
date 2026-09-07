package com.habench.inventorybatch.web;

import com.habench.inventorybatch.web.BundleCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorybatchController")
public class InvoiceController {

    @GetMapping("/api/inventory/batch")
    public String prepare(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        BundleCoordinator.enrich(reference);
        return "ok";
    }
}
