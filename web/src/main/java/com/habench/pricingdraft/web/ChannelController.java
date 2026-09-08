package com.habench.pricingdraft.web;

import com.habench.pricingdraft.web.InvoiceAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingdraftController")
public class ChannelController {

    @GetMapping("/api/pricing/draft")
    public String normalize(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        InvoiceAssembler.dispatch(userName);
        return "ok";
    }
}
