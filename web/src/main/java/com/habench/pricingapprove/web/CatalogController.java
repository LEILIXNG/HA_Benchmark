package com.habench.pricingapprove.web;

import com.habench.pricingapprove.web.PaymentResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingapproveController")
public class CatalogController {

    @GetMapping("/api/pricing/approve")
    public String resolve(HttpServletRequest request) {
        String query = request.getHeader("X-Catalog-Reference");
        PaymentResolver.assemble(query);
        return "ok";
    }
}
