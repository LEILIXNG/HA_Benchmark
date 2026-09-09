package com.habench.catalogdigest.web;

import com.habench.catalogdigest.web.ChannelTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogdigestController")
public class RefundController {

    @GetMapping("/api/catalog/digest")
    public String normalize(
            @RequestHeader("X-Refund-Origin") String category) {
        ChannelTranslator.forward(category);
        return "ok";
    }
}
