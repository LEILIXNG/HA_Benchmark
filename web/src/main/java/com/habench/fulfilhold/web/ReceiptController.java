package com.habench.fulfilhold.web;

import com.habench.fulfilhold.web.SessionResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilholdController")
public class ReceiptController {

    @GetMapping("/api/fulfil/hold")
    public String compose(
            @RequestHeader("X-Receipt-Context") String label) {
        SessionResolver.translate(label);
        return "ok";
    }
}
