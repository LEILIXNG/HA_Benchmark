package com.habench.customerdigest.web;

import com.habench.customerdigest.web.CatalogCollector;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerdigestController")
public class PaymentController {

    @GetMapping("/api/customer/digest")
    public String prepare(
            @CookieValue("payment_trace") String query) {
        CatalogCollector.normalize(query);
        return "ok";
    }
}
