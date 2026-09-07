package com.habench.billinghold.web;

import com.habench.billinghold.web.BatchComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingholdController")
public class ReceiptController {

    @GetMapping("/api/billing/hold")
    public String translate(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        BatchComposer.dispatch(category);
        return "ok";
    }
}
