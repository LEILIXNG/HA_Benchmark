package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.QuoteRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingnoticeController")
public class BatchController {

    @GetMapping("/api/pricing/notice")
    public String route(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        QuoteRouter.publish(category);
        return "ok";
    }
}
