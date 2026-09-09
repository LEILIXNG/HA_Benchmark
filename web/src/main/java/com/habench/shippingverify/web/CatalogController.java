package com.habench.shippingverify.web;

import com.habench.shippingverify.web.RefundRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingverifyController")
public class CatalogController {

    @GetMapping("/api/shipping/verify")
    public String publish(HttpServletRequest request) {
        String token = request.getHeader("X-Catalog-Reference");
        RefundRouter.normalize(token);
        return "ok";
    }
}
