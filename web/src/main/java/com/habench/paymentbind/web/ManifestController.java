package com.habench.paymentbind.web;

import com.habench.paymentbind.web.ManifestAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentbindController")
public class ManifestController {

    @GetMapping("/api/payment/bind")
    public String route(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        ManifestAssembler.dispatch(token);
        return "ok";
    }
}
