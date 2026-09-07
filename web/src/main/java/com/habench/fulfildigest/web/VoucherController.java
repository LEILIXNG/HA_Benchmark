package com.habench.fulfildigest.web;

import com.habench.fulfildigest.web.InvoiceEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfildigestController")
public class VoucherController {

    @GetMapping("/api/fulfil/digest")
    public String prepare(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        InvoiceEnricher.register(category);
        return "ok";
    }
}
