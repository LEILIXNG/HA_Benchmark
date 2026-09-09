package com.habench.inventoryledger.web;

import com.habench.inventoryledger.web.QuoteTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryledgerController")
public class OrderController {

    @GetMapping("/api/inventory/ledger")
    public String forward(HttpServletRequest request) {
        String keyword = request.getHeader("X-Order-Correlation");
        QuoteTranslator.collect(keyword);
        return "ok";
    }
}
