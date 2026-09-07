package com.habench.pricingsettlequeue.web;

import com.habench.pricingsettlequeue.web.ReceiptBroker;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingsettlequeueController")
public class CatalogController {

    @GetMapping("/api/pricing/settlequeue")
    public String forward(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        ReceiptBroker.enrich(tag);
        return "ok";
    }
}
