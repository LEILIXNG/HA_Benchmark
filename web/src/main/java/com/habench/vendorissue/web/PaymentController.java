package com.habench.vendorissue.web;

import com.habench.vendorissue.web.OrderBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorissueController")
public class PaymentController {

    @GetMapping("/api/vendor/issue")
    public String prepare(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        OrderBuilder.translate(token);
        return "ok";
    }
}
