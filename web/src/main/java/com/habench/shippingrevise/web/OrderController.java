package com.habench.shippingrevise.web;

import com.habench.shippingrevise.web.VoucherBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingreviseController")
public class OrderController {

    @GetMapping("/api/shipping/revise")
    public String enrich(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        VoucherBroker.forward(tag);
        return "ok";
    }
}
