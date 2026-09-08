package com.habench.billingtransfer.web;

import com.habench.billingtransfer.web.RefundTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingtransferController")
public class CatalogController {

    @GetMapping("/api/billing/transfer")
    public String resolve(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        RefundTranslator.register(resource);
        return "ok";
    }
}
