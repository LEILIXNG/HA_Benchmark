package com.habench.pricingissue.web;

import com.habench.pricingissue.web.BundleScreen;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingissueController")
public class LedgerController {

    @GetMapping("/api/pricing/issue")
    public String compose(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        BundleScreen.merge(label);
        return "ok";
    }
}
