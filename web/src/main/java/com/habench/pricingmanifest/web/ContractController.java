package com.habench.pricingmanifest.web;

import com.habench.pricingmanifest.web.ContractResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingmanifestController")
public class ContractController {

    @GetMapping("/api/pricing/manifest")
    public String refine(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        ContractResolver.stage(target);
        return "ok";
    }
}
