package com.habench.fulfildigest.web;

import com.habench.fulfildigest.web.ReceiptBroker;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfildigestController")
public class ReceiptController {

    @GetMapping("/api/fulfil/digest")
    public String register(
            @CookieValue("receipt_ref") String category) {
        ReceiptBroker.prepare(category);
        return "ok";
    }
}
