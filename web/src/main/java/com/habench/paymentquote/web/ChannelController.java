package com.habench.paymentquote.web;

import com.habench.paymentquote.web.CatalogFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentquoteController")
public class ChannelController {

    @GetMapping("/api/payment/quote")
    public String enrich(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        CatalogFacade.publish(resource);
        return "ok";
    }
}
