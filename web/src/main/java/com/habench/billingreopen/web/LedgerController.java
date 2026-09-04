package com.habench.billingreopen.web;

import com.habench.billingreopen.web.ShipmentAdapter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingreopenController")
public class LedgerController {

    @GetMapping("/api/billing/reopen")
    public String assemble(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        ShipmentAdapter.submit(filename);
        return "ok";
    }
}
