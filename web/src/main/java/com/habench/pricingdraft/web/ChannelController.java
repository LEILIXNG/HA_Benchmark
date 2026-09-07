package com.habench.pricingdraft.web;

import com.habench.pricingdraft.web.SessionResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingdraftController")
public class ChannelController {

    @GetMapping("/api/pricing/draft/{reference}")
    public String normalize(
            @PathVariable("reference") String reference) {
        SessionResolver.dispatch(reference);
        return "ok";
    }
}
