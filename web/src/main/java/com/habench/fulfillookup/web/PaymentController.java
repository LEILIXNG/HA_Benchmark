package com.habench.fulfillookup.web;

import com.habench.fulfillookup.web.OrderNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfillookupController")
public class PaymentController {

    @GetMapping("/api/fulfil/lookup")
    public String prepare(
            @RequestParam("userName") String userName) {
        OrderNormalizer.enrich(userName);
        return "ok";
    }
}
