package com.habench.paymentdraft.web;

import com.habench.paymentdraft.web.LedgerTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentdraftController")
public class BatchController {

    @GetMapping("/api/payment/draft")
    public String submit(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        LedgerTranslator.submit(keyword);
        return "ok";
    }
}
