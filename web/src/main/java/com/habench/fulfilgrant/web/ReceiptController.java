package com.habench.fulfilgrant.web;

import com.habench.fulfilgrant.web.SessionRegistry;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilgrantController")
public class ReceiptController {

    @GetMapping("/api/fulfil/grant")
    public String dispatch(
            @CookieValue("receipt_trace") String resource) {
        SessionRegistry.stage(resource);
        return "ok";
    }
}
