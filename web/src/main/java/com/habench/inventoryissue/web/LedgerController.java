package com.habench.inventoryissue.web;

import com.habench.inventoryissue.web.QuoteComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryissueController")
public class LedgerController {

    @GetMapping("/api/inventory/issue")
    public String forward(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        QuoteComposer.assemble(token);
        return "ok";
    }
}
