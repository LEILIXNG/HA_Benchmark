package com.habench.shippingrevise.web;

import com.habench.shippingrevise.web.CatalogCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingreviseController")
public class QuoteController {

    @GetMapping("/api/shipping/revise")
    public String merge(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        CatalogCoordinator.assemble(orderNo);
        return "ok";
    }
}
