package com.habench.shippingdigest.web;

import com.habench.shippingdigest.web.LedgerAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingdigestController")
public class LedgerController {

    @GetMapping("/api/shipping/digest")
    public String enrich(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        LedgerAssembler.route(target);
        return "ok";
    }
}
