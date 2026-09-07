package com.habench.vendorrefund.web;

import com.habench.vendorrefund.web.OrderNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorrefundController")
public class ShipmentController {

    @GetMapping("/api/vendor/refund")
    public String expand(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        OrderNormalizer.refine(label);
        return "ok";
    }
}
