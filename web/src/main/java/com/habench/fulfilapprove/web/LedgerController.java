package com.habench.fulfilapprove.web;

import com.habench.fulfilapprove.web.OrderTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilapproveController")
public class LedgerController {

    @GetMapping("/api/fulfil/approve")
    public String translate(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        OrderTranslator.assemble(tag);
        return "ok";
    }
}
