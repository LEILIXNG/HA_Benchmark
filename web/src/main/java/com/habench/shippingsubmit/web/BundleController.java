package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.BundleBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsubmitController")
public class BundleController {

    @GetMapping("/api/shipping/submit")
    public String compose(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        BundleBuilder.resolve(token);
        return "ok";
    }
}
