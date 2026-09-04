package com.habench.accountdigest.web;

import com.habench.accountdigest.web.CatalogBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountdigestController")
public class PaymentController {

    @GetMapping("/api/account/digest")
    public String submit(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        CatalogBroker.register(reference);
        return "ok";
    }
}
