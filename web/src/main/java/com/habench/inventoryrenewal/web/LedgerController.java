package com.habench.inventoryrenewal.web;

import com.habench.inventoryrenewal.web.TariffEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryrenewalController")
public class LedgerController {

    @GetMapping("/api/inventory/renewal")
    public String prepare(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        TariffEnricher.submit(reference);
        return "ok";
    }
}
