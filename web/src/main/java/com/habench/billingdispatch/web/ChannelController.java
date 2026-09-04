package com.habench.billingdispatch.web;

import com.habench.billingdispatch.web.RefundFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingdispatchController")
public class ChannelController {

    @GetMapping("/api/billing/dispatch")
    public String enrich(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        RefundFacade.forward(orderNo);
        return "ok";
    }
}
