package com.habench.inventoryrenewal.web;

import com.habench.inventoryrenewal.web.QuoteAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryrenewalController")
public class LedgerController {

    @GetMapping("/api/inventory/renewal")
    public String normalize(HttpServletRequest request) {
        String tag = request.getHeader("X-Ledger-Channel");
        QuoteAssembler.prepare(tag);
        return "ok";
    }
}
