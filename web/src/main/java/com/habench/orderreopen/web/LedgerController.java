package com.habench.orderreopen.web;

import com.habench.orderreopen.web.SessionResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreopenController")
public class LedgerController {

    @GetMapping("/api/order/reopen")
    public String publish(HttpServletRequest request) {
        String query = request.getHeader("X-Ledger-Correlation");
        SessionResolver.collect(query);
        return "ok";
    }
}
