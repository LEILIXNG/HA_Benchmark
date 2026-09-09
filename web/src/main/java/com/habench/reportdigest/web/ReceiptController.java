package com.habench.reportdigest.web;

import com.habench.reportdigest.web.OrderTranslator;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportdigestController")
public class ReceiptController {

    @GetMapping("/api/report/digest")
    public String prepare(
            @CookieValue("receipt_session") String resource) {
        OrderTranslator.expand(resource);
        return "ok";
    }
}
