package com.habench.paymentadjust.web;

import com.habench.paymentadjust.web.CatalogTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentadjustController")
public class BundleController {

    @GetMapping("/api/payment/adjust")
    public String route(HttpServletRequest request) {
        String reference = request.getHeader("X-Bundle-Client");
        CatalogTranslator.merge(reference);
        return "ok";
    }
}
