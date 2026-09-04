package com.habench.fulfilsync.web;

import com.habench.fulfilsync.web.LedgerAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsyncController")
public class ShipmentController {

    @GetMapping("/api/fulfil/sync")
    public String translate(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        LedgerAdapter.enrich(resource);
        return "ok";
    }
}
