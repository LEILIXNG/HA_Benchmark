package com.habench.paymentnotice.web;

import com.habench.paymentnotice.web.ChannelResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentnoticeController")
public class CatalogController {

    @GetMapping("/api/payment/notice")
    public String normalize(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        ChannelResolver.attach(token);
        return "ok";
    }
}
